package com.crowdFunding.common.api;

import com.crowdFunding.common.dto.FileUpLoadDTO;
import com.crowdFunding.common.dto.ChunkFileDTO;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "oss-provider")
public interface OSSRemoteService {

    /**
     * 保存文件，返回文件的地址
     *
     * @param fileUpLoadDTO
     * @return
     */
    @RequestMapping("/file/upload")
    ResultEntity<String> uploadFile(@RequestBody FileUpLoadDTO fileUpLoadDTO);

    /**
     * 初始化文件分片上传的记录
     *
     * @param fileId
     * @param fileName
     * @return
     */
    @RequestMapping("/init/upload")
    ResultEntity<String> initUpload(@RequestParam("fileId") String fileId,
                                    @RequestParam("fileName") String fileName);

    /**
     * 获取文件的url地址
     *
     * @param fileId
     * @return
     */
    @RequestMapping("/get/file/url")
    ResultEntity<String> getFileUrl(@RequestParam("fileId") String fileId);

    /**
     * 取消分片文件上传
     *
     * @param fileId 文件的唯一标识
     * @return
     */
    @RequestMapping("/cancel/resumable/upload")
    ResultEntity<String> cancelResumableUpload(@RequestParam("fileId") String fileId);
}
