package com.crowdFunding.redisProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class RedisProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisProviderApplication.class, args);
    }
}
