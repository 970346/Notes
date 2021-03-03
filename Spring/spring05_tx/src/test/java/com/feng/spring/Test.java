package com.feng.spring;

import com.feng.spring.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class Test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");

    @org.junit.Test
    public void test() throws FileNotFoundException {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkout("Tom","ISBN-001");
        System.out.println("结账完成！");
    }
}
