package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 微服务之间调用时的用户数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private Integer id;

    private String account;

    private String password;

    private String userName;

    private String email;

    private Byte authStatus;

    private Byte userType;

    private String realName;

    private String bankAccount;

    private Byte accountType;
}
