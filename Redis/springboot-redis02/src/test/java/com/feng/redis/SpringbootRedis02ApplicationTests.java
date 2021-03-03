package com.feng.redis;

import com.feng.redis.entity.User;
import com.feng.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootRedis02Application.class)
@RunWith(SpringRunner.class)
class SpringbootRedis02ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> findall = userService.findall();
        findall.forEach(user -> System.out.println(findall));

        System.out.println("---------------------");

        List<User> findall2 = userService.findall();
        findall2.forEach(user -> System.out.println(findall2));
    }

    @Test
    void usertestfindone(){
        User user = userService.findbyid(2);
        System.out.println(user);
        System.out.println("--------------------------------------------------------------------");
        User user2 = userService.findbyid(2);
        System.out.println(user2);
    }

    @Test
    void usertestclear(){
        userService.deluser(1);
    }

    @Test
    void usertestsave(){
        User user = new User();
        user.setName("wangtian");
        userService.save(user);
    }
    @Test
    void usertestupdate(){
        User user = new User();
        user.setName("wangliu");
        user.setId(5);
        userService.update(user);
    }
}
