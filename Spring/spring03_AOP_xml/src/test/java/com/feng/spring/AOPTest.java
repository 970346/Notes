package com.feng.spring;

import com.feng.spring.inter.impl.MyMathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        bean.add(1,2);
    }
}
