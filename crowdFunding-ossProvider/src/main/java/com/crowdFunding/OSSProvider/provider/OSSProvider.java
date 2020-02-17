package com.crowdFunding.OSSProvider.provider;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.crowdFunding.OSSProvider.Constant.OSSConstant;
import com.crowdFunding.OSSProvider.model.MultipartUploadParam;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.ChunkFileDTO;
import com.crowdFunding.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OSSProvider {

    private String videoDefaultSuffix = "mp4";

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;

    /**
     * 单个文件的上传
     *
     * @param inputStream
     * @param fileName
     * @return
     */
    public ResultEntity<String> fileUpload(InputStream inputStream, String fileName) {
        String generatedFileName;
        String[] splitFileName = StringUtils.split(fileName, ".");
        if (splitFileName.length > 1) {
            generatedFileName = UUID.randomUUID().toString() + "." + splitFileName[splitFileName.length - 1];
        } else {
            return ResultEntity.failed(Constant.INVALID_FILE_FORMAT);
        }
        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流("<yourBucketName>", "<yourObjectName>", inputStream)
            ossClient.putObject(bucketName, generatedFileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        //返回文件的网络访问路径
        String url = bucketName + "." + endpoint + "/" + generatedFileName;
        return ResultEntity.successWithData(url);
    }

    /**
     * 初始化分片上传
     *
     * @param fileId
     * @param fileName
     * @return
     */
    public ResultEntity<String> initResumableUpload(String fileId, String fileName) {
        //a.生成文件名****
        String objectName;
        String[] splitFileName = StringUtils.split(fileName, ".");
        if (splitFileName.length > 1) {
            objectName = UUID.randomUUID().toString() + "." + splitFileName[splitFileName.length - 1];
        } else {
            //上传文件的名称不符合规范，默认生成".mp4"的后缀
            log.warn("file name invalid,use default suffix 'mp4'");
            objectName = UUID.randomUUID().toString() + "." + videoDefaultSuffix;
        }
        //b.创建OSS实例****
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //c.创建InitiateMultipartUploadRequest对象。
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucketName, objectName);
        //d.初始化分片。
        InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
        //e.返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。****
        String uploadId = upresult.getUploadId();
        //g.关闭客户端
        ossClient.shutdown();

        MultipartUploadParam multipartUploadParam = new MultipartUploadParam();
        multipartUploadParam.setObjectName(objectName);
        multipartUploadParam.setUploadId(uploadId);

        ResultEntity<String> resultEntity1 = redisRemoteOperationService.setIfNotExist(UUID.randomUUID().toString(), fileId, JSON.toJSONString(multipartUploadParam));
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed();
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * 执行分片上传，返回执行结果
     *
     * @param chunkFileDTO
     * @return
     */
    public ResultEntity<String> uploadChunkFile(ChunkFileDTO chunkFileDTO) {
        //1.获取objectName uploadId
        String fileId = chunkFileDTO.getFileId();
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(fileId);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            log.warn("get multipart upload param failed. [fileId=" + fileId + "]");
            return resultEntity;
        }
        MultipartUploadParam multipartUploadParam = JSON.parseObject(resultEntity.getData(), MultipartUploadParam.class);
        String objectName = multipartUploadParam.getObjectName();
        String uploadId = multipartUploadParam.getUploadId();

        //2. 创建ossClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        //3. 上传分片
        PartETag partETag;
        try {
            InputStream inputStream = new ByteArrayInputStream(chunkFileDTO.getFileBlob());
            UploadPartRequest uploadPartRequest = new UploadPartRequest();
            uploadPartRequest.setBucketName(bucketName);
            uploadPartRequest.setKey(objectName);
            uploadPartRequest.setUploadId(uploadId);
            uploadPartRequest.setInputStream(inputStream);
            uploadPartRequest.setPartSize(chunkFileDTO.getFileBlob().length);  // 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100KB。
            uploadPartRequest.setPartNumber(chunkFileDTO.getChunkIndex() + 1); // 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
            UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);  // 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
            partETag = uploadPartResult.getPartETag();
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("upload chunkFile to  ali object storage server failed. [fileId=" + fileId + "]");
            log.warn(e.getMessage());
            return ResultEntity.failed();
        }
        //3. 上传成功，为partETags添加元素partETag
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.addElementToSet(OSSConstant.PART_E_TAGS + chunkFileDTO.getFileId(), JSON.toJSONString(partETag));
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            log.warn("add partETag to partETag list failed. [fileId=" + fileId + "]");
            return resultEntity1;
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * 执行文件合并，返回合并结果【失败/成功】
     *
     * @param fileId
     * @return
     */
    public ResultEntity<String> completeChunkFile(String fileId) {
        //1.获取objectName uploadId
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(fileId);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {   //查新失败，这种情况可能需要重试
            log.warn("get multipart upload param failed. [fileId=" + fileId + "]");
            return resultEntity;
        } else if (ResultEntity.NO_DATA.equals(resultEntity.getData())) {    //查询成功但没有结果（这种情况应该是不存在的）
            log.error("big error!!! multipart upload param not exist,please check redis database. [fileId=" + fileId + "]");
            return ResultEntity.failed();
        }
        MultipartUploadParam multipartUploadParam = JSON.parseObject(resultEntity.getData(), MultipartUploadParam.class);

        //2. 获取partETags
        ResultEntity<Set<String>> resultEntity1 = redisRemoteOperationService.retrieveSetByKey(OSSConstant.PART_E_TAGS + fileId);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {    //查新失败，这种情况可能需要重试
            log.warn("get partETags failed. [fileId=" + fileId + "]");
            return ResultEntity.failed();
        } else if (resultEntity1.getData() == null) {                   //查询成功但没有结果（这种情况应该是不存在的）
            log.error("big error!!! partETags not exist,please check redis database. [key=" + OSSConstant.PART_E_TAGS + fileId + "]");
            return ResultEntity.failed();
        }
        Set<String> partETagsSet = resultEntity1.getData();
        List<PartETag> partETags = partETagsSet.stream().map(item -> JSON.parseObject(item, PartETag.class)).collect(Collectors.toList());

        //3. 合并文件
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(bucketName,
                    multipartUploadParam.getObjectName(),
                    multipartUploadParam.getUploadId(),
                    partETags);
            CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

        //4. 删除 objectName uploadId partETags
        ResultEntity<String> resultEntity2 = redisRemoteOperationService.removeByKey(fileId);
        if (ResultEntity.FAILED.equals(resultEntity2.getStatus())) {
            log.warn("delete objectName and uploadId failed,please check and try again.  [fileId=" + fileId + "]");
        }
        ResultEntity<String> resultEntity3 = redisRemoteOperationService.removeSetByKey(OSSConstant.PART_E_TAGS + fileId);
        if (ResultEntity.FAILED.equals(resultEntity3.getStatus())) {
            log.warn("delete partETags failed,please check and try again.  [key=" + OSSConstant.PART_E_TAGS + fileId + "]");
        }

        return ResultEntity.successWithoutData();
    }

    /**
     * 获取文件的url地址
     *
     * @param fileId
     * @return
     */
    public ResultEntity<String> getFileUrl(String fileId) {
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(fileId);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {     //获取失败，可能需要重试
            return ResultEntity.failed(Constant.EGT_MULTIPAT_UPLOAD_PARAM_FAILED);
        }
        if (ResultEntity.NO_DATA.equals(resultEntity.getData())) {       //结果不存在（这种情况几乎不可能发生），打印错误日志
            log.error("get file url failed,caused by reids database,please check! [fileId=" + fileId + "]");
            return ResultEntity.failed();
        }

        MultipartUploadParam multipartUploadParam = JSON.parseObject(resultEntity.getData(), MultipartUploadParam.class);
        String objectName = multipartUploadParam.getObjectName();
        String url = bucketName + "." + endpoint + "/" + objectName;
        return ResultEntity.successWithData(url);
    }
}