package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 账号-密码方式登陆时用户信息数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInByAPInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String password;
}
