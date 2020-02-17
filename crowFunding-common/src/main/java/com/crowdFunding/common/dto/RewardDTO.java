package com.crowdFunding.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 众筹项目回报信息的数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    String projectTempToken;

    private Byte type;

    private Integer money;

    private String description;

    private String picture;

    private String remarks;  //新添加的  回报的备注信息

    private Integer limitedAmount;

    private Integer limitedPurchase;

    private Byte freight;

    private Byte rewardData;

    private Byte receipt;

}
