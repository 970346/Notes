package com.feng.spring3.dao;

import com.feng.spring3.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("保存了用户。。。");
    }
}
