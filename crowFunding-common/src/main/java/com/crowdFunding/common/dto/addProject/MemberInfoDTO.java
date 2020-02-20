package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 团队成员信息的传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String position;

    private String introduction;

    private String avatar;

}
