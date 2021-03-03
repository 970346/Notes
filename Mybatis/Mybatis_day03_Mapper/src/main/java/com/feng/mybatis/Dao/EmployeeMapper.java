package com.feng.mybatis.Dao;

import com.feng.mybatis.Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {
    public Employee getEmpByMap(Map<String,Object> map);

    public Employee getEmpByIdAndLastName(@Param("id") String id,@Param("lastname") String lastname);

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public boolean updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}
