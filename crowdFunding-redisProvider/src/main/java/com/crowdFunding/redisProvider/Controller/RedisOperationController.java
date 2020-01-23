package com.crowdFunding.redisProvider.Controller;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.CommonUtils;
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
    //@HystrixCommand(fallbackMethod = "saveKeyValueHystrix")
    public ResultEntity<String> saveKeyValue(@RequestParam("key") String key,
                                             @RequestParam("value") String value,
                                             @RequestParam("validTime") Integer validTime) {
        if (!CommonUtils.strCheckEffective(key)) {
            return ResultEntity.failed(Constant.INVALID_KEY);
        }
        if (!CommonUtils.strCheckEffective(value)) {
            return ResultEntity.failed(Constant.INVALID_VALUE);
        }
        if (validTime == null || validTime == 0) {
            return ResultEntity.failed(Constant.INVALID_VALID_TIME);
        }
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if (validTime < 0) {
            try {
                valueOperations.set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        } else {
            try {
                valueOperations.set(key, value, validTime, TimeUnit.MINUTES);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/retrieve/value/by/key")
    //@HystrixCommand(fallbackMethod = "retrieveValueByKeyHystrix")
    public ResultEntity<String> retrieveValueByKey(@RequestParam("key") String key) {
        if (!CommonUtils.strCheckEffective(key)) {
            return ResultEntity.failed(Constant.INVALID_KEY);
        } else {
            try {
                String value = stringRedisTemplate.opsForValue().get(key);
                if (value == null) {
                    return ResultEntity.failed(Constant.REDIS_EMPTY_RESULT);
                }
                return ResultEntity.successWithData(value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
    }

    @RequestMapping("/remove/by/key")
    //@HystrixCommand(fallbackMethod = "removeByKeyHystrix")
    public ResultEntity<String> removeByKey(@RequestParam("key") String key) {
        if (!CommonUtils.strCheckEffective(key)) {
            return ResultEntity.failed(Constant.INVALID_KEY);
        } else {
            try {
                boolean bool = stringRedisTemplate.delete(key);
                if (bool) {
                    return ResultEntity.successWithoutData();
                }
                return ResultEntity.failed(Constant.REDIS_DELETE_FAILED);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(e.getMessage());
            }
        }
    }
/**
 public ResultEntity<String> saveKeyValueHystrix(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("validTime") Integer validTime) {
 return ResultEntity.failed(Constant.REDIS_SAVE_FAILED_FUSE);
 }

 public ResultEntity<String> retrieveValueByKeyHystrix(@RequestParam("key") String key) {
 return ResultEntity.failed(Constant.REDIS_RETRIEVE_FAILED_FUSE);
 }

 public ResultEntity<String> removeByKeyHystrix(@RequestParam("key") String key) {
 return ResultEntity.failed(Constant.REDIS_REMOVE_FAILED_FUSE);
 }
 */
}
