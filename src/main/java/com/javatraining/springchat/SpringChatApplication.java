package com.javatraining.springchat;

import com.javatraining.springchat.config.CustomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class SpringChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringChatApplication.class, args);
    }

}
