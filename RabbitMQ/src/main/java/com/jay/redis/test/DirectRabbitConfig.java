package com.jay.redis.test;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Configuration
public class DirectRabbitConfig {

    //队列 起名：TestDirectQueue,叫什么名字没关系，主要是要与交换机绑定
    @Bean
    public Queue TestDirectQueue1() {
        return new Queue("TestDirectQueue1", true);  //true 是否持久
    }
    @Bean
    public Queue TestDirectQueue2() {
        return new Queue("TestDirectQueue2", true);  //true 是否持久
    }
    @Bean
    public Queue TestDirectQueue3() {
        return new Queue("TestDirectQueue3", true);  //true 是否持久
    }





    /*Direct交换机，需要绑定键值*/

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange1");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    //绑定了多个队列
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue1()).to(TestDirectExchange()).with("TestDirectRouting1");
    }
    @Bean
    Binding bindingDirect2() {
        return BindingBuilder.bind(TestDirectQueue2()).to(TestDirectExchange()).with("TestDirectRouting2");
    }
    @Bean
    Binding bindingDirect3() {
        return BindingBuilder.bind(TestDirectQueue3()).to(TestDirectExchange()).with("TestDirectRouting3");
    }





}
