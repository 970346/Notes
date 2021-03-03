package com.feng.spring.factory;
import com.feng.spring.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;


/**
 * 实现了FactoryBean接口的类是spring可以认识的工厂类
 * spring会自动的调用工厂方法创建实例
 *
 * 步骤：1、编写一个FactoryBean的实现类
 *       2、在spring配置文件中注册
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    /**
     * 工厂方法
     * 返回创建的对象
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImpl创建的对象");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建的对象类型
     * spring会自动调用这个方法来确认创建的对象是什么类型
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 判断是否是单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
