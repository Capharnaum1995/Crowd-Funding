package com.crowdFunding.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMS {
    private String host;
    private String path;
    private String sign;
    private String skin;
    private String param;
    private String phoneNumber;
    private String appCode;
}
