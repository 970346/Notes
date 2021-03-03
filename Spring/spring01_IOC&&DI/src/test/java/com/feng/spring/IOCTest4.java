package com.feng.spring;

import com.feng.spring2.Service.BookService;
import com.feng.spring2.Servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest4 {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc5.xml");

    @Test
    public void test2(){
//        BookServlet bookServlet = ioc.getBean(BookServlet.class);
//        bookServlet.doGet();
    }

    /**
     * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的：
     * 1、id默认为类名首字母小写
     * 2、组件默认为单例
     */
    @Test
    public void test(){
        Object bookDao = ioc.getBean("bookDao");
        Object bookDao2 = ioc.getBean("bookDao");
        System.out.println(bookDao==bookDao2);
    }
}
