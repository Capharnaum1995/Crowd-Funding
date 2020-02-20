package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 回报挡位信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private String projectTempToken;

    private List<Reward> rewardList;

}
