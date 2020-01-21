package com.crowdFunding.common;

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
        SMSUtils.sendMessage(phoneNumber, param);
    }
}
