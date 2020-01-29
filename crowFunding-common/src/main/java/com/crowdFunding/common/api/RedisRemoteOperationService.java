package com.crowdFunding.common.api;

import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 取回/查询
     *
     * @param key
     * @return
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

}
