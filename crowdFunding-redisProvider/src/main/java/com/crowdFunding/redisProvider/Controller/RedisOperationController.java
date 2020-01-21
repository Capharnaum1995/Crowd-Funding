package com.crowdFunding.redisProvider.Controller;

import com.crowdFunding.common.Entity.ResultEntity;
import com.crowdFunding.common.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisOperationController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @param key
     * @param value
     * @param validTime 正数表示过期时间，0或者null是不合法的，负数（-1）表示永久不过期
     * @return
     */
    @RequestMapping("/save/key/value")
    ResultEntity<String> saveKeyValue(@RequestParam("key") String key,
                                      @RequestParam("value") String value,
                                      @RequestParam("validTime") Integer validTime) {
        if (!SMSUtils.strCheckEffective(key) || !SMSUtils.strCheckEffective(value)) {
            return ResultEntity.failed("键值对无效！");
        }
        if (validTime == null || validTime == 0) {
            return ResultEntity.failed("validTime无效！");
        }
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if (validTime < 0) {
            try {
                valueOperations.set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
            return ResultEntity.successWithoutData();
        } else {
            try {
                valueOperations.set(key, value, validTime, TimeUnit.MINUTES);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
            return ResultEntity.successWithoutData();
        }
    }


    @RequestMapping("/retrieve/value/by/key")
    ResultEntity<String> retrieveValueByKey(@RequestParam("key") String key) {
        if (!SMSUtils.strCheckEffective(key)) {
            return ResultEntity.failed("键无效！");
        } else {
            try {
                String value = stringRedisTemplate.opsForValue().get(key);
                return ResultEntity.successWithData(value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
    }

    @RequestMapping("/remove/by/key")
    ResultEntity<String> removeByKey(@RequestParam("key") String key) {
        if (!SMSUtils.strCheckEffective(key)) {
            return ResultEntity.failed("键无效！");
        } else {
            try {
                stringRedisTemplate.delete(key);
                return ResultEntity.successWithoutData();
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
    }

}
