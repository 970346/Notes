package com.feng.spring;

import com.feng.spring.bean.Book;
import com.feng.spring.bean.Car;
import com.feng.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class IOCTest2 {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    /**
     * 实验四
     */
    @Test
    public void test(){
        /**
         *  测试null值
         *  默认引用类型就是null值
         */
        Person person = (Person) ioc.getBean("person");
        System.out.println(person.getLastName()==null);
        System.out.println(person.getCar());
        Car car = (Car) ioc.getBean("car");
        System.out.println(car);
        System.out.println(car==person.getCar());
    }
    @Test
    public void test2(){
        /**
         * 测试list
         */
        Person person = (Person) ioc.getBean("person02");
//        List<Book> books = person.getBooks();
//        System.out.println(books);
        /**
         * 测试map
         */
//        Map<String, Object> map = person.getMap();
//        System.out.println(map);
        /**
         * 测试properties
         */
//        Properties properties = person.getProperties();
//        System.out.println(properties);
        /**
         * 测试util
         */
//        Map<String, Object> map = person.getMap();
//        System.out.println(map);
//        Map<String, Object> mymap = (Map<String, Object>) ioc.getBean("mymap");
//        System.out.println(mymap.getClass());
        /**
         * 测试级联属性
         * 级联属性可以修改原对象的属性值
         */
        Person person2 = (Person) ioc.getBean("person03");
        Car car1 = (Car) ioc.getBean("car");
        System.out.println("car1"+car1);
        Car car = person2.getCar();
        System.out.println("car"+car.toString());
    }
    /**
     *  实验6：通过集成实现bean配置信息的重用
     */
    @Test
    public void test3(){
        Person person06 = (Person) ioc.getBean("person06");
        System.out.println(person06);
    }
    /**
     * 实验7：通过abstract属性创建一个模板bean
     * 异常：Bean definition is abstract
     */
    @Test
    public void test4(){
        Person person05 = (Person) ioc.getBean("person05");
        System.out.println(person05);
    }
    /**
     * 实验8：bean之间的依赖
     * depends-on:可以指定bean的创建顺序
     */
    private ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc3.xml");
    @Test
    public void test5(){

    }
    /**
     * 实验9：测试bean的作用域，分别创建单利和多例的bean
     */
    @Test
    public void test6(){
        System.out.println("容器启动完成");
        Book book2 = (Book) ioc2.getBean("book2");
        Book book3 = (Book) ioc2.getBean("book2");
        System.out.println(book2==book3);
    }
    /**
     * 实验5：
     */
    @Test
    public void test7(){
//        Object plane = ioc2.getBean("plane");
//        System.out.println(plane);
//        Object plane2 = ioc2.getBean("plane2");
//        System.out.println(plane2);
//        System.out.println("容器启动完成");
        Object bean = ioc2.getBean("factoryBean");
        System.out.println(bean);
    }
}
