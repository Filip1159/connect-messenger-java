package com.example.connectmessenger.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "custom")
@Validated
@Getter
@Setter
public class CustomProperties {
    private long JwtExpirationTime;
    private String secret;
}
