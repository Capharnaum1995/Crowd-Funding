package com.crowdFunding.common;

import com.crowdFunding.common.utils.SMS;
import com.crowdFunding.common.utils.SMSUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTests {
    @Test
    public void sendVerificationTest() {
        String phoneNumber = "18774002425";
        Integer integer = 4;
        String param = SMSUtils.generateRandomVerificationCode(integer);
        SMS sms = new SMS("https://feginesms.market.alicloudapi.com", "/codeNotice", "2", "1", param, phoneNumber, "0984aecf7af34501b67084312786a0f2");
        SMSUtils.sendMessage(sms);
    }

    @Test
    public void stringTest() {
        System.out.println(StringUtils.isAllBlank());               //true
        System.out.println(StringUtils.isAllBlank(""));       //true
        System.out.println(StringUtils.isAllBlank("   "));    //true
        System.out.println(StringUtils.isAllBlank("  llll")); //false
        System.out.println(StringUtils.isAllBlank("lllll"));  //false
        System.out.println(StringUtils.isAllEmpty());               //true
        System.out.println(StringUtils.isAllEmpty(""));       //true
        System.out.println(StringUtils.isAllEmpty("  "));     //false
        System.out.println(StringUtils.isAllEmpty("  11"));   //false
        System.out.println(StringUtils.isAllEmpty("111111")); //false
        System.out.println("-----------------");
        System.out.println(StringUtils.containsWhitespace(""));
        System.out.println(StringUtils.containsWhitespace(" "));
        System.out.println(StringUtils.containsWhitespace(" lo "));
        System.out.println(StringUtils.containsWhitespace("1 1 "));
        System.out.println(StringUtils.containsWhitespace("你好吗"));
        System.out.println("-----------------");
        System.out.println(StringUtils.isNotBlank(""));
        System.out.println(StringUtils.isNotBlank("   "));
        System.out.println(StringUtils.isNotBlank("  llll"));
        System.out.println(StringUtils.isNotBlank("lllll"));
        System.out.println("-----------------");
        System.out.println(StringUtils.isNotBlank(""));
        System.out.println(StringUtils.isNotBlank("   "));
        System.out.println(StringUtils.isNotBlank("  llll"));
        System.out.println(StringUtils.isNotBlank("lllll"));


    }
}
