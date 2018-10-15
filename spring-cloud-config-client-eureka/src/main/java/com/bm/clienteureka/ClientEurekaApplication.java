package com.bm.clienteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientEurekaApplication.class, args);
    }
}
