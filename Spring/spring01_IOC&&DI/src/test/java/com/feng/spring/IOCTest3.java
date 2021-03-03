package com.feng.spring;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class IOCTest3 {
    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

    /**
     * 实验10：创建带有生命周期方法的bean
     *
     * 单例：构造器----->初始化方法----->（容器关闭）销毁方法
     * 多例：获取bean----->初始化方法----->容器关闭（不调用销毁方法）
     */
    @Test
    public void test(){

        System.out.println("容器关闭");
        ioc.close();
    }
    /**
     * 实验11：测试bean的后置处理器
     * BeanPostProcessor是后置处理器接口
     *
     * 配置步骤：1、编写实现BeanPostProcessor接口的实现类
     *           2、在spring配置文件中注册
     *
     * 执行顺序：（容器启动）构造器----->后置处理器(postProcessBeforeInitialization方法)----->初始化方法
     *          ----->后置处理器(postProcessAfterInitialization方法)----->bean初始化完成
     *
     * 无论bean是否有初始化方法，后置处理器都会默认其有，还会继续工作
     */
    @Test
    public void test2(){
//        Object Book = ioc.getBean("Book");
//        System.out.println("容器关闭");
    }

    /**
     * 实验12：引用外部xml属性文件，以链接数据库为例
     */
    private ConfigurableApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc4.xml");
    @Test
    public void test3() throws SQLException {
        //1、从容器中拿到连接池
        //DataSource datasource = (DataSource) ioc.getBean("datasource");
        //2、按照类型获取组件，可以获取到这个类型下的所有实现类
        DataSource datasource = ioc2.getBean(DataSource.class);
        System.out.println(datasource.getConnection());
    }
    /**
     * 实验13：基于xml自动装配
     */
    @Test
    public void test4(){
        Object person = ioc2.getBean("person");
        System.out.println(person);
    }
    /**
     * 实验14：[spel测试]
     */
    @Test
    public void test5(){
        Object person = ioc2.getBean("person2");
        System.out.println(person);
    }
}
