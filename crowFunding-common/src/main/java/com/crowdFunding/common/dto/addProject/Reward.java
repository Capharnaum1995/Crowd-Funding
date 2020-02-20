package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {

    private Byte type;

    private Integer money;

    private String description;

    private String picture;

    private String remarks;

    private Integer limitedAmount;

    private Integer limitedPurchase;

    private Byte freight;

    private Byte rewardDate;

    private Byte receipt;

}
