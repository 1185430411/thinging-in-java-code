package com.jay.redis.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue2")//监听的队列名称 TestDirectQueue
public class DirectReceiver2 {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver2消费者收到消息  : " + testMessage.toString());
    }
}
