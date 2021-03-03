package com.feng.mybatis.Dao;

import com.feng.mybatis.Bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //查询携带了哪个字段就带上这个字段的值
    public Employee getEmpById(Integer id);
}
