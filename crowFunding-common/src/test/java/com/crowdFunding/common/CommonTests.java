package com.crowdFunding.common;

import com.crowdFunding.common.utils.SMS;
import com.crowdFunding.common.utils.SMSUtils;
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
}
