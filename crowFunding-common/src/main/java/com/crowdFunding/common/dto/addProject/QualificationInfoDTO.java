package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 资质信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationInfoDTO {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private String projectTempToken;

    private List<String> brandPatent;              //品牌专利委托

    private List<String> managePermit;             //经营许可证

    private List<String> productionPermit;         //生产许可

    private List<String> certification;            //3C认证

    private List<String> qualityReport;            //质检报告

    private List<String> businessLicense;          //营业执照

    private List<String> otherQualificationFile;   //其他证件

}
