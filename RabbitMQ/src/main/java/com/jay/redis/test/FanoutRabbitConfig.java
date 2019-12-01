package com.jay.redis.test;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    /*Fannot Exchange,广播模式,无需绑定键值，消息会加到这个转发机绑定下的所有队列*/

    //队列 起名：TestDirectQueue,叫什么名字没关系，主要是要与交换机绑定
    @Bean
    public Queue Queue1() {
        return new Queue("Queue1", true);  //true 是否持久
    }
    @Bean
    public Queue Queue2() {
        return new Queue("Queue2", true);  //true 是否持久
    }
    @Bean
    public Queue Queue3() {
        return new Queue("Queue3", true);  //true 是否持久
    }
    //配置fanout_exchange
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("Fanout");
    }

    //把所有的队列都绑定到这个交换机上去
    @Bean
    Binding bindingExchangeA(Queue Queue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue1).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue Queue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue2).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue Queue3, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue3).to(fanoutExchange);
    }
}
