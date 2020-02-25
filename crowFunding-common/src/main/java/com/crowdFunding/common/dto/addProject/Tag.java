package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    public static final String TAG_KEY = "TAG_KEY_4CAC0D82AC7A71A04A3D5B73496BF762";

    public static final Long TAG_VALID_TIME = 12 * 60L;    //缓存过期时间12小时

    private Integer id;

    private String name;

}
