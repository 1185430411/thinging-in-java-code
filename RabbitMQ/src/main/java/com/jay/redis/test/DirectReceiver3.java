package com.jay.redis.test;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue3")//监听的队列名称 TestDirectQueue
public class DirectReceiver3 {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver3消费者收到消息  : " + testMessage.toString());
    }
}
