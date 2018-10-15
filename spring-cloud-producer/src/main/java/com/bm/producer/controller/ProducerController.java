package com.bm.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 提供者
 */
@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String cloud(@RequestParam String name){
        return "Hello "+name+",The time is"+ new Date();
    }
}
