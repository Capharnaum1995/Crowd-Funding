package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发起人确认信息的数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitiatorInfoDTO {

    private String userToken;

    private String projectTempToken;

    private Integer userId;

    private String payNumber;

    private String idNumber;

}
