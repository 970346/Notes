package com.feng.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootRedis01Application.class)
@RunWith(SpringRunner.class)
public class TestBoundAPI {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 绑定key，方便对于key的操作
     */
    @Test
    public void testbound(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

//        BoundValueOperations<String, String> valueOps = stringRedisTemplate.boundValueOps("name");
//        valueOps.set("zhangsan");
//        valueOps.append("hello！");
//        String s = valueOps.get();
//        System.out.println(s);
//        Long size = valueOps.size();
//        System.out.println(size);

        BoundListOperations<String, String> lists = stringRedisTemplate.boundListOps("lists");
        lists.leftPushAll("张三","李四","王五");
        List<String> range = lists.range(0, -1);
        range.forEach(s -> System.out.println(s));

    }
}
