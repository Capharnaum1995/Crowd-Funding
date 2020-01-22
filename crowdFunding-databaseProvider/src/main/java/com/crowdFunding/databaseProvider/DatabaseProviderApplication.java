package com.crowdFunding.databaseProvider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.crowdFunding.databaseProvider.mapper")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class DatabaseProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseProviderApplication.class, args);
    }
}
