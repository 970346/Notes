package com.feng.spring.Dao;

import com.feng.spring.Bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void saveEmployee(Employee employee){
        String sql = "insert into employee(emp_name,salary) values(?,?)";
        jdbcTemplate.update(sql,employee.getEmpName(),employee.getSalary());
    }
}
