package com.crowdFunding.ui.handler;

import com.crowdFunding.common.api.OSSRemoteService;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.ChunkFileDTO;
import com.crowdFunding.common.dto.FileUpLoadDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.ui.producer.MsgProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class FileUpLoadHandler {

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;

    @Autowired
    private OSSRemoteService ossRemoteService;

    @PostMapping("/file/upload")
    public Object fileUpLoad(HttpServletRequest request) {
        //这里可以不用做校验，project-manager服务中会做校验
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //https://github.com/pandao/editor.md/blob/master/examples/php/upload.php(getFile("editormd-image-file")参数的来源)
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file_data");
        String userToken = multipartHttpServletRequest.getParameter("userToken");       //获取参数
        Map<String, String> response = new HashMap<>();
        byte[] content;
        try {
            content = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            response.put("error", Constant.FILE_UP_LOAD_FAILED);
            return response;
        }
        FileUpLoadDTO fileUpLoadDTO = new FileUpLoadDTO();
        fileUpLoadDTO.setUserToken(userToken);
        fileUpLoadDTO.setContent(content);
        fileUpLoadDTO.setFileName(multipartFile.getOriginalFilename());
        ResultEntity<String> resultEntity = ossRemoteService.uploadFile(fileUpLoadDTO);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            response.put("error", Constant.FILE_UP_LOAD_FAILED);
            return response;
        }
        return resultEntity;
    }

    @PostMapping("/resumable/file/upload")
    public Object resumableFileUpLoad(HttpServletRequest request) {

        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String userToken = multipartHttpServletRequest.getParameter("userToken");
        Map<String, String> response = new HashMap<>();

        //1.检验用户是否登录
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(userToken);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus()) || ResultEntity.NO_DATA.equals(resultEntity.getData())) {
            return response.put("error", Constant.PLEASE_LOG_IN);
        }

        //2.从前端获取文件分片
        String fileId = multipartHttpServletRequest.getParameter("fileId");
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("fileBlob");
        String chunkIndex = multipartHttpServletRequest.getParameter("chunkIndex");
        String chunkCount = multipartHttpServletRequest.getParameter("chunkCount");
        String fileName = multipartHttpServletRequest.getParameter("fileName");

        //初始化上传记录,先查，再锁式的创建
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(fileId);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus()) || ResultEntity.NO_DATA.equals(resultEntity1.getData())) {
            ResultEntity<String> resultEntity2 = ossRemoteService.initUpload(fileId, fileName);
            if (ResultEntity.FAILED.equals(resultEntity2.getStatus())) {
                return response.put("error", "file upload initialize failed，please try again!");
            }
        }

        //3.创建文件传输对象
        if (multipartFile == null) {
            return response.put("error", "chunk file lose,please try again!");
        }
        ChunkFileDTO chunkFileDTO = new ChunkFileDTO();
        try {
            chunkFileDTO.setFileBlob(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return response.put("error", "chunk file IOException,please try again!");
        }
        chunkFileDTO.setFileId(fileId);
        chunkFileDTO.setChunkIndex(Integer.parseInt(chunkIndex));
        chunkFileDTO.setChunkCount(Integer.parseInt(chunkCount));
        chunkFileDTO.setFileName(fileName);

        //4.上传文件
        ResultEntity<String> resultEntity3 = msgProducer.produceChunkFile(chunkFileDTO);
        if (ResultEntity.FAILED.equals(resultEntity3.getStatus())) {
            return response.put("error", "chunk file up load failed,please try again!");
        } else {
            response.put("chunkIndex", chunkIndex);
            return response;  //为什么这里不能直接写成[return response.put("chunkIndex", chunkIndex);],否则前端会接收到错误的json数据
        }
    }

    @RequestMapping("/complete/chunk/file")
    public ResultEntity<String> completeChunkFile(@RequestParam("fileId") String fileId) {
        ResultEntity<String> resultEntity;
        //2. 先获取文件的url
        ResultEntity<String> resultEntity1 = ossRemoteService.getFileUrl(fileId);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            resultEntity = ResultEntity.failed(Constant.GET_FILE_URL_FAILED);
        } else {
            resultEntity = resultEntity1;
        }

        //3.发起文件合并指令
        ChunkFileDTO chunkFileDTO = new ChunkFileDTO();
        chunkFileDTO.setFileId(fileId);
        chunkFileDTO.setComplete(true);
        msgProducer.produceChunkFile(chunkFileDTO);

        return resultEntity;
    }
}
