package com.jay.redis.test;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

//往redis中存入对象的方法


@Data
@ToString
class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

@RestController
public class test {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @GetMapping("/test")
    public  void test1(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());  //设置key的序列化方式
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());  //设置value的序列化方式
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("student1",new Student("jay",19));
        Student student=(Student)redisTemplate.opsForValue().get("student1");
        System.out.println(student);
    }
}
