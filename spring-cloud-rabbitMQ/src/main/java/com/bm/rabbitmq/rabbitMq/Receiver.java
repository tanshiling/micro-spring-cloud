package com.bm.rabbitmq.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title: Receiver
 * @Package com.bm.rabbitmq.rabbitMq
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/14 16:17
 */
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "queue1")
    public void receiver(String text){

        System.out.println("接收消息：" + text);
    }
}
