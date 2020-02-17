package com.crowdFunding.redisProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

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

    @Test
    public void test() {
        String value = "value的初始值";
        try {
            value = stringRedisTemplate.opsForValue().get("userToken");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(value);
    }

    @Test
    public void test1() {
        try {
            stringRedisTemplate.opsForList().rightPush("ig", "TheShy");
            stringRedisTemplate.opsForList().rightPush("ig", "rookie");
            stringRedisTemplate.opsForList().rightPush("ig", "JK");
            stringRedisTemplate.opsForList().rightPush("ig", "Ning");
            stringRedisTemplate.opsForList().rightPush("ig", "Leyan");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        try {
            List<String> list = stringRedisTemplate.opsForList().range("ig", 0, -1);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            stringRedisTemplate.opsForList().remove("ig", 0, "*");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test4() {
        try {
            //清空list的方法
            stringRedisTemplate.opsForList().trim("ig", -1, 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test5() {
        String key = "ig";
        long l1 = stringRedisTemplate.opsForSet().add(key, "TheShy");
        long l2 = stringRedisTemplate.opsForSet().add(key, "Rookie");
        long l3 = stringRedisTemplate.opsForSet().add(key, "JKLove");
        long l4 = stringRedisTemplate.opsForSet().add(key, "Ning");
        long l5 = stringRedisTemplate.opsForSet().add(key, "Leyan");
        long l6 = stringRedisTemplate.opsForSet().add(key, "TheShy");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l5);
        System.out.println(l6);
    }

    @Test
    public void test6() {
        String key = "ig";
        String otherKey = "{" + key + "}" + UUID.randomUUID().toString();
        long l = stringRedisTemplate.opsForSet().intersectAndStore(key, otherKey, key);
        System.out.println(l);
    }

}
