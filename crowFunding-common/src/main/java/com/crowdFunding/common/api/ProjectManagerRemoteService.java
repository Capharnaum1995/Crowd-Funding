package com.crowdFunding.common.api;

import com.crowdFunding.common.dto.InitiatorInfoDTO;
import com.crowdFunding.common.dto.ProjectDTO;
import com.crowdFunding.common.dto.RewardDTO;
import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "project-manager")
public interface ProjectManagerRemoteService {

    /**
     * 初始化项目（发起众筹时的“同意并继续”）
     *
     * @param token
     * @return
     */
    @RequestMapping("/project/manager/init/project")
    ResultEntity<String> initProject(@RequestParam("token") String token);

    /**
     * 保存项目的基本信息(包括promoterInfo)
     *
     * @param projectDTO
     * @return
     */
    @RequestMapping("/project/manager/save/project/basic/info")
    ResultEntity<String> saveProjectBasicInfo(@RequestBody ProjectDTO projectDTO);

    /**
     * 保存回报设置的信息
     *
     * @param rewardDTO
     * @return
     */
    @RequestMapping("/project/manager/save/reward/info")
    ResultEntity<String> saveRewardInfo(@RequestBody RewardDTO rewardDTO);

    /**
     * 保存发起人信息
     *
     * @param initiatorInfoDTO
     * @return
     */
    @RequestMapping("/project/manager/initiator/info/confirm")
    ResultEntity<String> savaInitaitorConfirmInfo(@RequestBody InitiatorInfoDTO initiatorInfoDTO);

    /**
     * 最终确认发起众筹项目
     *
     * @param userToken
     * @param projectTempToken
     * @return
     */
    @RequestMapping("/project/manager/submit/project/info")
    ResultEntity<String> submitProjectInfo(@RequestParam("userToken") String userToken,
                                           @RequestParam("projectTempToken") String projectTempToken);
}
