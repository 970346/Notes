package com.feng.spring2.Servlet;

import com.feng.spring2.Dao.BookDao;
import com.feng.spring2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookServlet {
    @Autowired
    private BookService bookService;

    public void doGet(){
        bookService.save();
    }
    /**
     *  当方法上有@Autowired注解时：
     * 1、这个方法也会在bean创建的时候自动运行
     * 2、这个方法上的每一个参数都会自动注入值
     */
    @Autowired
    public void ahhh(BookDao bookDao){
        System.out.println("spring运行了这个方法..."+bookDao);
    }

}
