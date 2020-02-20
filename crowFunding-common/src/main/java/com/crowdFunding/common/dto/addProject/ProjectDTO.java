package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 众筹项目信息的数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private BasicInfoDTO projectBasicInfoDTO;                   //基本信息

    private List<RewardDTO> rewardDTOList;                      //挡位

    private PromotionalMaterialDTO promotionalMaterialDTO;      //推广资料

    private QualificationInfoDTO qualificationInfoDTO;          //资质信息

    private InitiatorInfoDTO initiatorInfoDTO;                  //发起人的信息


}
