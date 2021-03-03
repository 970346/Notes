package com.feng.mp;

import com.baomidou.mybatisplus.plugins.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Test {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
    /*测试乐观锁*/
    @org.junit.Test
    public void testOprimisticlocker(){
        //更新操作
        Employee employee = new Employee();
        employee.setId(21);
        employee.setLastName("zxc");
        employee.setEmail("asd@qq.com");
        employee.setGender(1);
        employee.setAge(40);
        employee.setVersion(3);
        employeeMapper.updateById(employee);
    }
    /*测试性能分析插件*/
    @org.junit.Test
    public void testPerformance(){
        Employee employee = new Employee();
        employee.setLastName("asdasd");
        employee.setEmail("zxc@qq.com");
        employee.setAge(20);
        employee.setGender(1);
        employeeMapper.insert(employee);
    }
    /*测试sql分析插件测试*/
    @org.junit.Test
    public void testExplain(){
        employeeMapper.delete(null);
    }
    /*分页插件测试*/
    @org.junit.Test
    public void testPAge(){
        Page<Employee> page = new Page<>(1,1);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        System.out.println(employees);
        System.out.println("================获取分页信息====================");
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("总页码："+page.getPages());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
        //将查询的结构封装到page对象中
    }
}
