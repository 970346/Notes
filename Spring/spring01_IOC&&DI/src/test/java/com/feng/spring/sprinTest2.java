package com.feng.spring;

import com.feng.spring3.service.BookService;
import com.feng.spring3.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ioc是一个容器，帮我们管理所有的组件
 * 1、依赖注入：@Autowired：自动赋值
 * 2、某个组件要使用spring提供的更多（IOC、AOP）必须加入到容器中
 * 体会：
 * 1、容器启动，创建所有单实例bean
 * 2、@Autowired自动装配的时候，是从容器中找这些符合要求的bean
 * 3、ioc.getBean("xx")：也是从容器中找bean
 * 4、容器中包含了所有的bean
 * 5、容器实际上是一个map，把保存了所有的创建好的bean
 * */
public class sprinTest2 {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc6.xml");
    @Test
    public void test(){
        BookService bookService = ioc.getBean(BookService.class);
        UserService userService = ioc.getBean(UserService.class);
        bookService.save();
        userService.save();
    }
}
