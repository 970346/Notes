package com.feng.spring;

import com.feng.spring.Bean.Employee;
import com.feng.spring.Dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

    @org.junit.Test
    public void test9(){
        EmployeeDao bean = ioc.getBean(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setEmpName("haha");
        employee.setSalary(1351.1513);
        bean.saveEmployee(employee);
    }

    @org.junit.Test
    public void test8(){
        String sql = "insert into employee(emp_name,salary) values(:empName,:salary)";
        Employee employee = new Employee();
        employee.setEmpName("haha");
        employee.setSalary(1351.1513);
        int update = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
        System.out.println(update);
    }

    /**
     * 具名参数：参数为变量名
     * 占位符参数：每一个？代表一个参数，顺序不可乱
     */
    @org.junit.Test
    public void test7(){
        String sql = "insert into employee(emp_name,salary) values(:empName,:salary)";
        Map<String,Object> map = new HashMap<>();
        map.put("empName","田七");
        map.put("salary",9983.746);
        int update = namedParameterJdbcTemplate.update(sql, map);
        System.out.println(update);
    }

    @org.junit.Test
    public void test6(){
        String sql="select max(salary) from employee";
        Double aDouble = jdbcTemplate.queryForObject(sql, Double.class);
        System.out.println(aDouble);

    }

    @org.junit.Test
    public void test5(){
        String sql="select emp_id empId,emp_name empName,salary from employee where salary>?";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), 4000);
        System.out.println(employees);


    }
    @org.junit.Test
    public void test4(){
        String sql="select emp_id empId,emp_name empName,salary from employee where emp_id=?";
        Employee employee = null;
        try {
            employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 5);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }

    @org.junit.Test
    public void test3(){
        String sql = "insert into employee(emp_name,salary) values(?,?)";
        //list的长度为sql执行的次数
        //数组为要插入的参数
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"张三",998.98});
        list.add(new Object[]{"李四",1998.98});
        list.add(new Object[]{"王五",2998.98});
        list.add(new Object[]{"赵六",3998.98});
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void test2(){
        String sql="update employee set salary=? where emp_id=?";
        int update = jdbcTemplate.update(sql, 1300.00, 5);
        System.out.println(update);
    }

    @org.junit.Test
    public void test() throws SQLException {
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @org.junit.Test
    public void test1() throws SQLException {
        System.out.println(jdbcTemplate);
    }
}
