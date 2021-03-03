package com.feng.redis.dao;

import com.feng.redis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findbyid(Integer id);

    void deluser(Integer id);

    void save(User user);

    void update(User user);
}
