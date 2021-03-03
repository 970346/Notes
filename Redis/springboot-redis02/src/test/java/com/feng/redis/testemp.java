package com.feng.redis;

import com.feng.redis.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootRedis02Application.class)
@RunWith(SpringRunner.class)
public class testemp {
    @Autowired
    private EmpService empService;

    @Test
    public void findall(){
        empService.findall().forEach(emp -> System.out.println(emp));
        System.out.println("---------------------------------------------");
        empService.findall().forEach(emp -> System.out.println(emp));
    }
}
