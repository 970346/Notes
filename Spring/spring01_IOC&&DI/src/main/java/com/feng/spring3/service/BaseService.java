package com.feng.spring3.service;

import com.feng.spring3.dao.BaseDao;
import com.feng.spring3.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;
    public void save(){
        baseDao.save();
    }
}
