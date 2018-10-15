package com.bm.rabbitmq.rabbitMq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title: Sender
 * @Package com.bm.rabbitmq.rabbitMq
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/14 16:14
 */
@Component
public class Sender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    public void send(){

        amqpTemplate.convertAndSend("queue01","Hello mq");
    }
}
