package com.jay.redis.test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class rabbit {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test1")
    public String sendDirectMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange1", "TestDirectRouting1", map);
        return "ok";
    }

    @GetMapping("/fanout")
    public String test2(){
        for(int i=0;i<100;i++){
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "test message, hello"+i;
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String,Object> map=new HashMap<>();
            map.put("messageId",messageId);
            map.put("messageData",messageData);
            map.put("createTime",createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("Fanout","",map);
        }
        return "ok";
    }
}
