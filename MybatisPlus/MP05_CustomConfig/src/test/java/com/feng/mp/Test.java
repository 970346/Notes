package com.feng.mp;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.plugins.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.beans.User;
import com.feng.mp.mapper.EmployeeMapper;
import com.feng.mp.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
    private UserMapper userMapper = ioc.getBean("userMapper",UserMapper.class);
    /**
     * 测试公共字段填充
     */
    @org.junit.Test
    public void testMetaObjectHandler(){
        User user = new User();
        user.setLogicFlag(1);
//        userMapper.insert(user);
        user.setId(5);
        userMapper.updateById(user);
    }
    /**
     *测试逻辑删除
     */
    @org.junit.Test
    public void testLogicDelete(){
//        Integer result = userMapper.deleteById(1);
//        System.out.println(result);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    /**
     * 测试自定义全局操作
     */
    @org.junit.Test
    public void testMySqlInjector(){
        Integer result = employeeMapper.deleteAll();
        System.out.println(result);
    }
}
