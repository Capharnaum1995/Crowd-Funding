package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 团队成员信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String name;

    private String position;

    private String introduction;

    private String avatar;

}
