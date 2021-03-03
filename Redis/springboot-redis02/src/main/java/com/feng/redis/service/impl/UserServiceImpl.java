package com.feng.redis.service.impl;

import com.feng.redis.dao.UserDao;
import com.feng.redis.entity.User;
import com.feng.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> findall() {
        return userDao.findAll();
    }

    @Override
    public User findbyid(Integer id) {
        return userDao.findbyid(id);
    }

    @Override
    public void deluser(Integer id) {
        userDao.deluser(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
