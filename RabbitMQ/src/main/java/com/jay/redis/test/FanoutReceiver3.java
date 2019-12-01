package com.jay.redis.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "Queue3")//监听的队列名称 TestDirectQueue
public class FanoutReceiver3 {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("Receiver3消费者收到消息  : " + testMessage.toString());
    }
}
