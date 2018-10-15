package com.bm.consumer.controller;

import com.bm.consumer.feign.Consumer2Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer2Controller {

    @Autowired
    Consumer2Feign consumer2Feign;

    @RequestMapping("/hello/{name}")
    public String consumer2(@PathVariable("name") String name){
        return consumer2Feign.consumer2(name);
    }
}
