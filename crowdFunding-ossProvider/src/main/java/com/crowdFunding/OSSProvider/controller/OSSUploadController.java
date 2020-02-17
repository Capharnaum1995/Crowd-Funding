package com.crowdFunding.OSSProvider.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.model.PartETag;
import com.crowdFunding.OSSProvider.provider.OSSProvider;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.FileUpLoadDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class OSSUploadController {

    @Autowired
    private OSSProvider ossProvider;

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;


    /**
     * 保存文件，返回文件的地址
     *
     * @param fileUpLoadDTO
     * @return
     */
    @RequestMapping("/file/upload")
    ResultEntity<String> uploadFile(@RequestBody FileUpLoadDTO fileUpLoadDTO) {
        String userToken = fileUpLoadDTO.getUserToken();
        if (!CommonUtils.strCheckEffective(userToken)) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        //1. 验证用户是否登录
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(userToken);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        //2. 若用户已经登陆，上传文件
        try {
            return ossProvider.fileUpload(new ByteArrayInputStream(fileUpLoadDTO.getContent()), fileUpLoadDTO.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 初始化文件分片上传的记录
     *
     * @param fileId
     * @param fileName
     * @return
     */
    @RequestMapping("/init/upload")
    ResultEntity<String> initUpload(@RequestParam("fileId") String fileId,
                                    @RequestParam("fileName") String fileName) {
        return ossProvider.initResumableUpload(fileId, fileName);
    }

    /**
     * 获取文件的url地址
     *
     * @param fileId
     * @return
     */
    @RequestMapping("/get/file/url")
    ResultEntity<String> getFileUrl(@RequestParam("fileId") String fileId) {
        return ossProvider.getFileUrl(fileId);
    }

}
