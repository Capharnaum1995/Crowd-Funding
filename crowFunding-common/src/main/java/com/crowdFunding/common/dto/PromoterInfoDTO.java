package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 团队成员信息的传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoterInfoDTO {

    private String name;

    private String position;

    private String introduction;

    private String avatar;

}
