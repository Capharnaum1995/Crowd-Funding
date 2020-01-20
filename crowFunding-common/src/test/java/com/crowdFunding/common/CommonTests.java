package com.crowdFunding.common;

import com.crowdFunding.common.utils.SMSUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommonTests {
    @Test
    public void sendVerificationTest() {
        SMSUtils.sendMessage("18774002425");
    }
}
