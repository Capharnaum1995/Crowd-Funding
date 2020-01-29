package com.crowdFunding.projectManager.controller;

import com.alibaba.fastjson.JSON;
import com.crowdFunding.common.api.DatabaseRemoteOperationService;
import com.crowdFunding.common.api.RedisRemoteOperationService;
import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.InitiatorInfoDTO;
import com.crowdFunding.common.dto.ProjectDTO;
import com.crowdFunding.common.dto.RewardDTO;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.CommonUtils;
import com.crowdFunding.common.utils.OSSUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProjectController {

    @Autowired
    private RedisRemoteOperationService redisRemoteOperationService;

    @Autowired
    private DatabaseRemoteOperationService databaseRemoteOperationService;

    @Value("${oss.endpoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.bucketName}")
    private String bucketName;

    /**
     * 初始化项目（发起众筹时的“同意并继续”）
     *
     * @param token
     * @return
     */
    @RequestMapping("/project/manager/init/project")
    public ResultEntity<String> initProject(@RequestParam("token") String token) {
        if (!CommonUtils.strCheckEffective(token)) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(token);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        //创建一个空的projectDTO对象
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setUserToken(token);
        String projectTempToken = Constant.REDIS_PROJECT_TEMP_PREFIX + UUID.randomUUID().toString();
        projectDTO.setProjectTempToken(projectTempToken);
        String projectDTOJsonString = JSON.toJSONString(projectDTO);
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.saveKeyValue(projectTempToken, projectDTOJsonString, -1);
        //返回结果
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed(resultEntity1.getMessage());
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * 保存项目的基本信息(包括promoterInfo)
     *
     * @param projectDTO
     * @return
     */
    @RequestMapping("/project/manager/save/project/basic/info")
    public ResultEntity<String> saveProjectBasicInfo(@RequestBody ProjectDTO projectDTO) {
        if (!CommonUtils.strCheckEffective(projectDTO.getUserToken())) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(projectDTO.getUserToken());
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(projectDTO.getProjectTempToken());
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed(Constant.PROJECT_INVALID);
        }
        ProjectDTO projectDTO1 = JSON.parseObject(resultEntity1.getData(), ProjectDTO.class);
        BeanUtils.copyProperties(projectDTO, projectDTO1);
        return redisRemoteOperationService.saveKeyValue(projectDTO1.getProjectTempToken(), JSON.toJSONString(projectDTO1), -1);
    }


    /**
     * 保存图片文件,返回图片的地址
     *
     * @param userToken 用户的token
     * @return
     */
    @RequestMapping("/project/manager/upload/picture")
    public ResultEntity<String> uploadPicture(@RequestParam("userToken") String userToken, HttpServletRequest httpServletRequest) {
        if (!CommonUtils.strCheckEffective(userToken)) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        //1. 验证用户是否登录
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(userToken);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        //2. 若用户已经登陆，获取图片的输入流
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        InputStream inputStream;
        try {
            inputStream = multipartHttpServletRequest.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        //3. 输入流获取成功，上传图片
        return OSSUtils.uploadPicture(endpoint, accessKeyId, accessKeySecret, bucketName, inputStream);
    }

    /**
     * 保存回报设置的信息
     *
     * @param rewardDTO
     * @return
     */
    @RequestMapping("/project/manager/save/reward/info")
    public ResultEntity<String> saveRewardInfo(@RequestBody RewardDTO rewardDTO) {
        if (!CommonUtils.strCheckEffective(rewardDTO.getUserToken())) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(rewardDTO.getUserToken());
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(rewardDTO.getProjectTempToken());
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed(Constant.PROJECT_INVALID);
        }
        ProjectDTO projectDTO = JSON.parseObject(resultEntity1.getData(), ProjectDTO.class);
        List<RewardDTO> rewardDTOList = projectDTO.getRewardDTOList();
        if (rewardDTOList == null) {    //需要判断缓存中原有的projectDTO对象的rewardDTOList是否为空,若为空则为其创建以一个list,保证其rewardDTOList字段不为空
            rewardDTOList = new ArrayList<>();
            projectDTO.setRewardDTOList(rewardDTOList);
        }
        rewardDTOList.add(rewardDTO);
        return redisRemoteOperationService.saveKeyValue(projectDTO.getProjectTempToken(), JSON.toJSONString(projectDTO), -1);
    }

    /**
     * 保存发起人信息
     *
     * @param initiatorInfoDTO
     * @return
     */
    @RequestMapping("/project/manager/initiator/info/confirm")
    public ResultEntity<String> savaInitaitorConfirmInfo(@RequestBody InitiatorInfoDTO initiatorInfoDTO) {
        if (!CommonUtils.strCheckEffective(initiatorInfoDTO.getPayNumber())) {
            return ResultEntity.failed(Constant.INVALID_PAY_NUMBER);
        }
        if (!CommonUtils.strCheckEffective(initiatorInfoDTO.getIdNumber())) {
            return ResultEntity.failed(Constant.INVALID_ID_NUMBER);
        }
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(initiatorInfoDTO.getUserToken());
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(initiatorInfoDTO.getProjectTempToken());
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed(Constant.PROJECT_INVALID);
        }
        ProjectDTO projectDTO = JSON.parseObject(resultEntity1.getData(), ProjectDTO.class);

        initiatorInfoDTO.setUserId(Integer.parseInt(resultEntity.getData()));
        projectDTO.setInitiatorInfoDTO(initiatorInfoDTO);
        return redisRemoteOperationService.saveKeyValue(projectDTO.getProjectTempToken(), JSON.toJSONString(projectDTO), -1);
    }

    /**
     * 最终确认发起众筹项目
     *
     * @param userToken
     * @param projectTempToken
     * @return
     */
    @RequestMapping("/project/manager/submit/project/info")
    public ResultEntity<String> submitProjectInfo(@RequestParam("userToken") String userToken,
                                                  @RequestParam("projectTempToken") String projectTempToken) {
        //1. 验证信息
        if (!CommonUtils.strCheckEffective(userToken)) {
            return ResultEntity.failed(Constant.INVALID_TOKEN);
        }
        if (!CommonUtils.strCheckEffective(projectTempToken)) {
            return ResultEntity.failed(Constant.INVALID_PROJECT_TEMP_TOKEN);
        }
        ResultEntity<String> resultEntity = redisRemoteOperationService.retrieveValueByKey(userToken);
        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
            return ResultEntity.failed(Constant.PLEASE_LOG_IN);
        }
        //2. 从Redis中获取项目的缓存信息
        ResultEntity<String> resultEntity1 = redisRemoteOperationService.retrieveValueByKey(projectTempToken);
        if (ResultEntity.FAILED.equals(resultEntity1.getStatus())) {
            return ResultEntity.failed(Constant.PROJECT_INVALID);
        }
        //3. 获取成功，将设置项目的gmtCreate属性
        ProjectDTO projectDTO = JSON.parseObject(resultEntity1.getData(), ProjectDTO.class);
        projectDTO.setGmtCreate(System.currentTimeMillis());
        //4. 进行数据库的插入操作
        ResultEntity<String> resultEntity2 = databaseRemoteOperationService.createProject(projectDTO);
        if (ResultEntity.FAILED.equals(resultEntity2.getStatus())) {
            return resultEntity2;
        }
        //5. 项目创建成功，删除redis中的缓存数据
        ResultEntity<String> resultEntity3 = redisRemoteOperationService.removeByKey(projectTempToken);
        if (ResultEntity.FAILED.equals(resultEntity3.getStatus())) {
            return ResultEntity.failed(Constant.PROJECT_CACHE_REMOVE_FAILED);
        }
        //6. 缓存删除成功，返回操作成功的信息
        return ResultEntity.successWithoutData();
    }

}

