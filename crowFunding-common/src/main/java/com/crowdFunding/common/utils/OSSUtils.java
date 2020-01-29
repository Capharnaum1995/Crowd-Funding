package com.crowdFunding.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.crowdFunding.common.entity.ResultEntity;

import java.io.InputStream;
import java.util.UUID;

public class OSSUtils {

    /**
     * 上传文件到云服务器
     *
     * @param endpoint
     * @param accessKeyId
     * @param accessKeySecret
     * @param bucketName
     * @param inputStream
     * @return 文件的路径
     */
    public static ResultEntity<String> uploadPicture(String endpoint, String accessKeyId, String accessKeySecret, String bucketName, InputStream inputStream) {
        String fileName = UUID.randomUUID().toString();
        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流("<yourBucketName>", "<yourObjectName>", inputStream)
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        //返回文件的网络访问路径
        String url = bucketName + "." + endpoint + "/" + fileName;
        return ResultEntity.successWithData(url);
    }
}
