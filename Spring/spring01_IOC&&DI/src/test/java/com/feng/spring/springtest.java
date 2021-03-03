package com.feng.spring;

import com.feng.spring2.Servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *spring单元测试
 * 1、导入spring-test包
 * 2、使用@ContextConfiguration(locations = "")注解指定配置文件的位置
 * 3、@RunWith()指定用哪种驱动进行单元测试，默认为junit.
 *      (SpringJUnit4ClassRunner.class)使用spring单元测时驱动来进行测试
 */
@ContextConfiguration(locations = "classpath:ioc5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class springtest {
    @Autowired
    BookServlet bookServlet;
    @Test
    public void test(){
        System.out.println(bookServlet);
    }
}
