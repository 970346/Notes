package com.feng.spring2.Service;

import com.feng.spring2.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public void save(){
        System.out.println("bookService..正在调用dao帮你保存图书...");
        bookDao.saveBook();
    }
}
