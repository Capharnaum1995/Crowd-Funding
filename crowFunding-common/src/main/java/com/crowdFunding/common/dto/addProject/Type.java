package com.crowdFunding.common.dto.addProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    public static final String TYPE_KEY = "TYPE_KEY_D7AFB2A2FC9243D4B13D074BE3277784";

    public static final Long TYPE_VALID_TIME = 12 * 60L;   //缓存的过期时间为12小时

    private Integer id;

    private String name;

}
