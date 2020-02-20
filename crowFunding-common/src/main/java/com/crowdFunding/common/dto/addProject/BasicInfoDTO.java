package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 项目基本信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private String projectTempToken;

    private Byte type;

    private Byte day;

    private Long money;

    private List<Integer> typeList;

    private List<Integer> tagList;

    private String name;

    private String mainDescription;

    private String highlight;

    private Byte returnPurchase;

    private String crowdFundingStory;

    private String companyFile;

    private String teamFile;

    private List<MemberInfoDTO> memberInfoDTOList;

}
