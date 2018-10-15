package com.bm.servereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerEurekaApplication.class, args);
    }
}
