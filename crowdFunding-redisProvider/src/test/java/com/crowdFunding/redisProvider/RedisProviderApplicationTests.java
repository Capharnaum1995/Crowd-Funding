package com.crowdFunding.redisProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisProviderApplicationTests {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void saveValueToRedisByRedisTemplate() {
        redisTemplate.opsForValue().set("Tiberius Hsu", "6666666666");
    }

    @Test
    public void saveValueToRedisByStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("White Vinegar", "7777777777777");
    }
}
