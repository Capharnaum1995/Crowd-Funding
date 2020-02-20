package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 推广资料
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionalMaterialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userToken;

    private String projectTempToken;

    private String importantBlockDisplay;    //重点楼层展示图

    private String pcHomeDisplay;           //PC首页展示图

    private String pcProductDisplay;        //PC单品页展示图

    private String video;                   //pc单品页视频展示

}
