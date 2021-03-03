package com.feng.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@SpringBootTest(classes = SpringbootRedis01Application.class)
@RunWith(SpringRunner.class)
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        //修改key的序列化方案
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Users users = new Users();
        users.setId(UUID.randomUUID().toString());
        users.setName("张三");
        users.setAge(20);
        users.setBirth(new Date());
        redisTemplate.opsForValue().set("user",users);

        Users user = (Users) redisTemplate.opsForValue().get("user");
        System.out.println(user);

    }

}
