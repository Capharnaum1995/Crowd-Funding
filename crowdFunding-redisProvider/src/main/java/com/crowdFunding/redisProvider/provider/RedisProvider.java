package com.crowdFunding.redisProvider.provider;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.entity.ResultEntity;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisProvider {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    public ResultEntity<String> setIfNotExistWithValidTime(String lock, String key, String value, Long validTime) {
        if (validTime == null || validTime == 0) {
            return ResultEntity.failed(Constant.INVALID_VALID_TIME);
        }
        //1. 获取锁对象
        RLock fairLock = redissonClient.getFairLock(lock);
        //2. 尝试加锁，最多等待60秒，上锁以后10秒自动解锁
        boolean res;
        try {
            res = fairLock.tryLock(60, 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return ResultEntity.failed(Constant.REDISSION_LOCK_INTERRUPTED_EXCEPTION);
        }
        if (!res) {
            return ResultEntity.failed(Constant.REDISSION_LOCK_FAILED);
        }
        //3. 上锁成功，先查询
        String result;
        try {
            result = stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            fairLock.unlock();
            e.printStackTrace();
            return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
        }
        //4.1 存在记录，释放锁，返回
        if (result != null) {
            fairLock.unlock();
            return ResultEntity.successWithoutData();
        }
        //4.2 不存在记录，添加记录，释放锁，返回
        try {
            if (validTime < 0) {
                stringRedisTemplate.opsForValue().set(key, value);
            } else {
                stringRedisTemplate.opsForValue().set(key, value, validTime, TimeUnit.MINUTES);
            }
        } catch (Exception e) {
            fairLock.unlock();
            e.printStackTrace();
            return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
        }
        fairLock.unlock();
        return ResultEntity.successWithoutData();
    }
}
