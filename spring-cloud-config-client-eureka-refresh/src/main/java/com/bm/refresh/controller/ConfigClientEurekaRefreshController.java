package com.bm.refresh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //当发现的数据变化时自动刷新(需要得到通知)
public class ConfigClientEurekaRefreshController {

    @Value("${profile}")
    private String profile;

    @RequestMapping("/profile")
    public String getProfile(){
        return profile;
    }
}
