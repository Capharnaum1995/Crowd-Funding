package com.crowdFunding.common.utils;

import com.crowdFunding.common.constant.Constant;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public class CommonUtils {
    /**
     * 判断字符串是否有效。有效返回true,无效返回false。
     *
     * @param string
     * @return
     */
    public static boolean strCheckEffective(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;                    //字符串为null或者为空字符串("")
        } else if (StringUtils.containsWhitespace(string)) {
            return false;                    //字符串包含空格
        }
        return true;
    }

    public static String generateToken() {
        return Constant.SIGNED_USER_TOKEN_PREFIX + UUID.randomUUID().toString();
    }
}
