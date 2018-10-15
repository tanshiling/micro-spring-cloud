package com.bm.rabbitmq.controller;

import com.bm.rabbitmq.rabbitMq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Title: testMq
 * @Package com.bm.rabbitmq.controller
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/14 16:20
 */
@RestController
@RequestMapping("/mq")
public class testMq {

    @Autowired
    public Sender sender;

    @PostMapping("/test")
    public String testRabbitMq(){
        sender.send();
        return "send OK.";
    }
}
