package com.bm.redis.controller;

import com.bm.redis.entity.User;
import com.bm.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Title: RedisController
 * @Package com.bm.redis.controller
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/8 16:37
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    UserService userService;

    @RequestMapping("/set")
    public void set(){
        userService.set("key1",new User(1,"aaa",23));
    }

    @RequestMapping("/get")
    public String get(){
        return userService.get("key1").getName();
    }

    @RequestMapping("/stringSet")
    public void stringSet(){
        userService.setCode("stringKey","bbb");
    }

    @RequestMapping("/stringGet")
    public String stringGet(){
        return userService.getCode("stringKey");
    }
}
