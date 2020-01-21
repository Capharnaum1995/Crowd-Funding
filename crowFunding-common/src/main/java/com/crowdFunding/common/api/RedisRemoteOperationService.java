package com.crowdFunding.common.api;

import com.crowdFunding.common.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "redis-provider")
public interface RedisRemoteOperationService {

    /**
     * 保存验证码时调用的远程方法
     *
     * @param key
     * @param value
     * @param validTime 验证码的有效时间，以分钟为单位
     * @return
     */
    @RequestMapping("/save/key/value")
    ResultEntity<String> saveKeyValue(@RequestParam("key") String key,
                                      @RequestParam("value") String value,
                                      @RequestParam("validTime") Integer validTime);

    /**
     * 取回验证码时调用的远程方法
     *
     * @param key
     * @return
     */
    @RequestMapping("/retrieve/value/by/key")
    ResultEntity<String> retrieveValueByKey(@RequestParam("key") String key);

    /**
     * 删除验证码时调用的远程方法
     *
     * @param key
     * @return
     */
    @RequestMapping("/remove/by/key")
    ResultEntity<String> removeByKey(@RequestParam("key") String key);

}
