package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    private String phoneNumber;

    private String verificationCode;

}
