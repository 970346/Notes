package com.feng.spring;

import com.feng.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    /**
     * 总结：1、容器中对象的创建在容器创建完成的时候就已经创建好了
     *       2、同一个组件在ioc容器中是单实例的；容器启动完成都已经创建准备好的
     *       3、容器中如果没有这个组件，获取组件时会报：NoSuchBeanDefinitionException异常
     *       4、ioc容器在创建对象的时候，（property）会利用setter方法为javaBean的属性进行赋值
     *       5、javaBean的属性名是由getter/setter方法名决定的
     */
    /**
     * 从容器中拿到这个组件
     * 实验1：通过ioc容器创建对象，并为属性赋值
     */
    @Test
    public void test(){
        //ApplicationContext：代表ioc容器
        //ClassPathXmlApplicationContext：当前应用的xml配置文件
        //根据Spring配置文件得到ioc容器对象
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }
    /**
     * 通过bean的类型从ioc容器中获取bean的实例
     * 当容器中有多个对象时会出现NoUniqueBeanDefinitionException异常
     */
    @Test
    public void test02(){
//        Person person = ioc.getBean(Person.class);
//        System.out.println(person);

        Person person2 = ioc.getBean("person2", Person.class);
        System.out.println(person2);
        Person person3 = ioc.getBean("person3", Person.class);
        System.out.println(person3);
        Person person4 = ioc.getBean("person4", Person.class);
        System.out.println(person4);
        Person person5 = ioc.getBean("person5", Person.class);
        System.out.println(person5);
        Person person6 = ioc.getBean("person6", Person.class);
        System.out.println(person6);
    }
}
