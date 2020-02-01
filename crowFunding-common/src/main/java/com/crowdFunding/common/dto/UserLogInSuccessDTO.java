package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登陆成功时返回给前端的用户信息数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogInSuccessDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String userName;

    private String token;
}
