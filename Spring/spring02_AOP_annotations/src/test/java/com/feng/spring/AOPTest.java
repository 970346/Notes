package com.feng.spring;

import com.feng.spring.inter.Calculator;
import com.feng.spring.inter.impl.MyMathCalculator;
import com.feng.spring.proxy.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test2(){
        //从ioc容器中拿到目标对象。需要使用接口类型
//        Calculator bean = ioc.getBean(Calculator.class);
//        bean.add(2,1);

        //如果没有借口，则找本类类型。cglib会自动创建好代理对象
        MyMathCalculator beans = ioc.getBean(MyMathCalculator.class);
        beans.add(1,2);
    }

    /**
     * 有了动态代理，日志记录可以做的非常强大，并且减低了业务逻辑中的耦合性
     *
     * 缺点：1、写起来复杂
     *       2、jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为他创建代理对象的
     */
    @Test
    public void test(){
//        Calculator calculator = new MyMathCalculator();
//        calculator.add(1,2);

        //如果是拿到了这个对象的代理对象，代理对下你给执行操作
//        Calculator proxy = CalculatorProxy.getProxy(calculator);
//        proxy.add(5,2);



    }
}
