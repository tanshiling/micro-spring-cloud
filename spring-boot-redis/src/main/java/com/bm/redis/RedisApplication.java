package com.bm.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        System.getProperties().put("projectName", "springApp");
        SpringApplication.run(RedisApplication.class, args);
    }
}
