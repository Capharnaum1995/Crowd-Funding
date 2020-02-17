package com.crowdFunding.common.api;

import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "redis-provider")
public interface RedisRemoteOperationService {

    /**
     * 保存
     *
     * @param key
     * @param value
     * @param validTime 缓存数据的有效时间，以分钟为单位
     * @return
     */
    @RequestMapping("/save/key/value")
    ResultEntity<String> saveKeyValue(@RequestParam("key") String key,
                                      @RequestParam("value") String value,
                                      @RequestParam("validTime") Integer validTime);

    /**
     * 查询
     *
     * @param key
     * @return [successWithoutData:不存在] [successWithData:存在] [failed:查询失败]
     */
    @RequestMapping("/retrieve/value/by/key")
    ResultEntity<String> retrieveValueByKey(@RequestParam("key") String key);

    /**
     * 删除
     *
     * @param key
     * @return
     */
    @RequestMapping("/remove/by/key")
    ResultEntity<String> removeByKey(@RequestParam("key") String key);

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
                                       @RequestParam("value") String value);

    /**
     * 返回Set
     *
     * @param key
     * @return [successWithoutData:不存在] [successWithData:存在] [failed:查询失败]
     */
    @RequestMapping("/retrieve/set/by/key")
    ResultEntity<Set<String>> retrieveSetByKey(@RequestParam("key") String key);

    /**
     * 删除set
     *
     * @param key
     * @return
     */
    @RequestMapping("/remove/set/by/key")
    ResultEntity<String> removeSetByKey(@RequestParam("key") String key);

    /**
     * set添加
     *
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("/add/element/to/set")
    ResultEntity<String> addElementToSet(@RequestParam("key") String key,
                                         @RequestParam("value") String value);

}
