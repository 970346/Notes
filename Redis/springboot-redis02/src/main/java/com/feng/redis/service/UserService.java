package com.feng.redis.service;

import com.feng.redis.entity.User;

import java.util.List;

public interface UserService {
    List<User> findall();

    User findbyid(Integer id);

    void deluser(Integer id);

    void save(User user);

    void update(User user);
}
