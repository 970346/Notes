package com.feng.mybatis.Dao;

import com.feng.mybatis.Bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);
}
