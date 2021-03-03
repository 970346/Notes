package com.feng.mp;

import com.baomidou.mybatisplus.plugins.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
    /**
     * 删除操作
     */
    @org.junit.Test
    public void testCommonDelete(){
        /*根据主键id删除*/
//        Integer integer = employeeMapper.deleteById(12);
        /*根据条件进行删除*/
//        Map<String,Object> columnMap = new HashMap<String, Object>();
//        columnMap.put("last_name","MP");
//        columnMap.put("email","MP@atguigu.com");
//        Integer integer = employeeMapper.deleteByMap(columnMap);
        /*批量操作*/
        List<Integer> idList = new ArrayList<>();
        idList.add(6);
        idList.add(7);
        Integer integer = employeeMapper.deleteBatchIds(idList);
        System.out.println(integer);
    }
    /**
     * 查询操作
     */
    @org.junit.Test
    public void testCommonSelect(){
        /*通过主键id查询*/
//        Employee employee = employeeMapper.selectById(2);
        /*通过多个条件进行查询*/
//        Employee employeeone = new Employee();
//        employeeone.setId(7);
//        employeeone.setLastName("mm");
//        Employee employee = employeeMapper.selectOne(employeeone);
        /*通过多个id进行查询*/
//        List<Integer> idList = new ArrayList<>();
//        idList.add(4);
//        idList.add(5);
//        idList.add(6);
//        idList.add(7);
//        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        /*通过Map封装条件查询*/
//        Map<String,Object> columnMap = new HashMap<String, Object>();
//        columnMap.put("last_name","MP");
//        columnMap.put("gender","1");
//        List<Employee> employees = employeeMapper.selectByMap(columnMap);
        /*分页查询*/
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 2), null);
        System.out.println(employees);
    }
    /**
     * 更新操作
     */
    @org.junit.Test
    public void testCommonUpdate(){
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("mm");
        employee.setEmail("mm@atguigu.com");
        employee.setGender(0);
//        employee.setAge(33);
//        Integer integer = employeeMapper.updateById(employee);
        Integer integer = employeeMapper.updateAllColumnById(employee);
        System.out.println(integer);
    }
    /**
     * 插入操作
     */
    @org.junit.Test
    public void testCommonInsert(){
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("MP@atguigu.com");
        employee.setGender(1);
        employee.setAge(22);
        employee.setSalary(200.0);
        //插入操作
        /*  insert方法
            会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        * */
//        Integer insert = employeeMapper.insert(employee);
        /*  insertAllColumn方法
            当遇到属性值为空时，插入null
        * */
        Integer insert = employeeMapper.insertAllColumn(employee);
        System.out.println("result:"+insert);
        //获取当前数据在数据库中的主键值
        Integer id = employee.getId();
        System.out.println(id);
    }

    @org.junit.Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
