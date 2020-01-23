package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登陆成功时返回给前端的用户信息数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogInSuccessDTO {

    private String account;

    private String userName;

    private String token;
}
