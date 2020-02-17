package com.crowdFunding.OSSProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.crowdFunding.common.api")
public class OSSProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OSSProviderApplication.class, args);
    }
}
