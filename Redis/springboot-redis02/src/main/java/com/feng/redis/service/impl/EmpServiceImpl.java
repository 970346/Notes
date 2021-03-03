package com.feng.redis.service.impl;

import com.feng.redis.dao.EmpDao;
import com.feng.redis.entity.Emp;
import com.feng.redis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> findall() {
        return empDao.findAll();
    }
}
