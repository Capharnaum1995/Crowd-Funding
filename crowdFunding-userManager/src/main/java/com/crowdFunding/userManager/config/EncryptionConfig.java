package com.crowdFunding.userManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncryptionConfig {

    @Bean
    public BCryptPasswordEncoder getPasswordEncryption() {
        return new BCryptPasswordEncoder();
    }
}
