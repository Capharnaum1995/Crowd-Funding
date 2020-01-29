package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 众筹项目信息的数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private String userToken;

    private String projectTempToken;

    private Byte day;  //

    private Byte type;  //

    private String name;   //

    private String mainDescription;   //

    private String highlight;  //

    private Long money;  //

    private Byte returnPurchase;  //

    private String crowdFundingStory;  //

    private String whyCrowdFunding;  //

    private String companyFile;  //

    private String teamFile;  //

    //private Byte status;  // 众筹的状态，默认是0(即将开始)

    //private Long gmtDeploy;  //  众筹发布时间，应该是后台审核通过的时间

    //private Long fundMoney;  //  已经筹到的钱数，刚开始默认是0

    private Integer initiatorId; //

    private Long gmtCreate;  //  ******众筹创建时间

    private String headerPicture;  //

    private List<Integer> typeList;

    private List<Integer> tagList;

    private List<PromoterInfoDTO> promoterInfoDTOList;

    private List<RewardDTO> rewardDTOList;

    private InitiatorInfoDTO initiatorInfoDTO;


}
