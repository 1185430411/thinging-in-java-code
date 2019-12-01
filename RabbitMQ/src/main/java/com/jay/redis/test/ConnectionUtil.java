package com.jay.redis.test;

//用于创建连接的工具类

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public static Connection getConnection()throws Exception{
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.199.133");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("123");
        connectionFactory.setVirtualHost("/test");
        return connectionFactory.newConnection();
    }
}
