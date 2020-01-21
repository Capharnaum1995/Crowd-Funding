package com.crowdFunding.userManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//启动类这里必须注解接口RedisRemoteOperationService所在的包，不然UserController中RedisRemoteOperationService会无法注入。
@EnableFeignClients("com.crowdFunding.common.api")
public class UserManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }
}
