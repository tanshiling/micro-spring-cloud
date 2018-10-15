package com.bm.clienteureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientEurekaController {

    @Value("${profile}")
    private String profile;

    @RequestMapping("/profile")
    public String getProfile(){
        return profile;
    }
}
