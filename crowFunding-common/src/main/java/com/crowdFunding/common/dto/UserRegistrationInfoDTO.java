package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationInfoDTO {
    private String account;
    private String password;
    private String phoneNumber;
    private String verificationCode;
}
