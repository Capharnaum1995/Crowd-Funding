package com.crowdFunding.ui;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UIApplicationTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test1() {
        rocketMQTemplate.convertAndSend("Test-Topic", "Hello world!");
    }

}
