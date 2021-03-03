package com.feng.redis.dao;

import com.feng.redis.entity.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface EmpDao {

    Emp findById(Integer id);

    List<Emp> findAll();

    void insert(Emp emp);

    void update(Emp emp);

    void deleteById(Integer id);

}