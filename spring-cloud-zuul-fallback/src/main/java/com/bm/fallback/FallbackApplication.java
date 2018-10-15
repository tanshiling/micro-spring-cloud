package com.bm.fallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class FallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FallbackApplication.class, args);
    }
}
