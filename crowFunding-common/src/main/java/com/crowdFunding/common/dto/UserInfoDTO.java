package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 微服务之间调用时的用户数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
