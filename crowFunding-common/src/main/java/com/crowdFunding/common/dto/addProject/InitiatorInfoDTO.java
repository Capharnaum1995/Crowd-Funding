package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 发起人确认信息的数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitiatorInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private Integer userId;

    private String payNumber;

    private String idNumber;

}
