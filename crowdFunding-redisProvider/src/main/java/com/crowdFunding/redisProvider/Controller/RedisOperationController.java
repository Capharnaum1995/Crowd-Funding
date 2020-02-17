package com.crowdFunding.redisProvider.Controller;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.entity.ResultEntity;
import com.crowdFunding.common.utils.CommonUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisOperationController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

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
        if (validTime < 0) {
            try {
                stringRedisTemplate.opsForValue().set(key, value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
            }
        } else {
            try {
                stringRedisTemplate.opsForValue().set(key, value, validTime, TimeUnit.MINUTES);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
            }
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * 查询
     *
     * @param key
     * @return [successWithoutData:不存在] [successWithData:存在] [failed:查询失败]
     */
    @RequestMapping("/retrieve/value/by/key")
    //@HystrixCommand(fallbackMethod = "retrieveValueByKeyHystrix")
    public ResultEntity<String> retrieveValueByKey(@RequestParam("key") String key) {
        if (!CommonUtils.strCheckEffective(key)) {
            return ResultEntity.failed(Constant.INVALID_KEY);
        } else {
            try {
                String value = stringRedisTemplate.opsForValue().get(key);
                if (value == null) {
                    return ResultEntity.successWithoutData();
                }
                return ResultEntity.successWithData(value);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
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
                return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
            }
        }
    }

    /**
     * 如果不存在则添加一条记录
     *
     * @param lock
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/set/if/not/exist")
    ResultEntity<String> setIfNotExist(@RequestParam("lock") String lock,
                                       @RequestParam("key") String key,
                                       @RequestParam("value") String value) {

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
            stringRedisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            fairLock.unlock();
            e.printStackTrace();
            return ResultEntity.failed(Constant.REDIS_CALL_FAILED + " " + e.getMessage());
        }
        fairLock.unlock();
        return ResultEntity.successWithoutData();
    }

    /**
     * 返回Set
     *
     * @param key
     * @return [failed:查询失败]
     */
    @RequestMapping("/retrieve/set/by/key")
    ResultEntity<Set<String>> retrieveSetByKey(@RequestParam("key") String key) {
        try {
            Set<String> set = stringRedisTemplate.opsForSet().members(key);
            return ResultEntity.successWithData(set);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * 删除set
     *
     * @param key
     * @return
     */
    @RequestMapping("/remove/set/by/key")
    ResultEntity<String> removeSetByKey(@RequestParam("key") String key) {
        String otherKey = "{" + key + "}" + UUID.randomUUID().toString();//集合运算时，要求两个集合在一个hashSlot中,key的{}之内的值才会参与运算
        try {
            //清空集合的方法，将集合与空集求交集，并将结果储存在原来的集合中
            stringRedisTemplate.opsForSet().intersectAndStore(key, otherKey, key);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * set添加
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/add/element/to/set")
    ResultEntity<String> addElementToSet(@RequestParam("key") String key,
                                         @RequestParam("value") String value) {
        try {
            stringRedisTemplate.opsForSet().add(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
        return ResultEntity.successWithoutData();
    }

    /**
     * redis的list添加操作
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/add/element/to/list")
    public ResultEntity<String> addElementToList(@RequestParam("key") String key,
                                                 @RequestParam("value") String value) {
        if (!CommonUtils.strCheckEffective(key)) {
            return ResultEntity.failed(Constant.INVALID_KEY);
        }
        try {
            stringRedisTemplate.opsForList().rightPush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(Constant.REDIS_ADD_ELEMENT_TO_LIST_FAILED + "  " + e.getMessage());
        }
        return ResultEntity.successWithoutData();
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
