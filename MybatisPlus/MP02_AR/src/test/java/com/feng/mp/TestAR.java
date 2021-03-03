package com.feng.mp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAR {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    /**
     * AR   分页操作
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();
        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1, 1), new EntityWrapper<Employee>().like("last_name", "a"));
        System.out.println(employeePage);
        List<Employee> records = employeePage.getRecords();
        System.out.println(records);
    }
    /**
     * AR   删除操作
     * 注意：删除不存在的数据，在逻辑上也是成功的
     */
    @Test
    public void testARDelete(){
        Employee employee = new Employee();
//        boolean b = employee.deleteById(16);
//        employee.setId(15);
//        boolean b = employee.deleteById();
        boolean b = employee.delete(new EntityWrapper<Employee>().like("last_name", "T"));
        System.out.println(b);
    }
    /**
     * AR   查询操作
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();
//        Employee employee1 = employee.selectById(14);
//        employee.setId(14);
//        Employee employee1 = employee.selectById();
//        List<Employee> employees = employee.selectAll();
//        List<Employee> employees = employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
        int gender = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
        System.out.println(gender);
    }
    /**
     * AR   修改操作
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee();
        employee.setId(14);
        employee.setLastName("xxx");
        employee.setEmail("ss@21312asd.com");
        employee.setGender(1);
        employee.setAge(30);
        boolean b = employee.updateById();
        System.out.println(b);
    }
    /**
     * AR   插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setLastName("xxx");
        employee.setEmail("ss@asd.com");
        employee.setGender(1);
        employee.setAge(30);
        boolean b = employee.insert();
        System.out.println(b);
    }
}
