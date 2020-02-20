package com.crowdFunding.ui.handler;

import com.crowdFunding.common.dto.addProject.BasicInfoDTO;
import com.crowdFunding.common.dto.addProject.RewardDTO;
import com.crowdFunding.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddProjectHandler {

    /**
     * 保存项目的基本信息
     *
     * @param basicInfoDTO
     * @return
     */
    @PostMapping("/save/project/basic/info")
    public ResultEntity<String> saveProjectBasicInfo(@RequestBody BasicInfoDTO basicInfoDTO) {

        return null;
    }

    /**
     * 保存项目的挡位
     *
     * @param rewardDTO
     * @return
     */
    @PostMapping("/save/reward")
    public ResultEntity<String> saveReward(@RequestBody RewardDTO rewardDTO) {

        return null;
    }


}
