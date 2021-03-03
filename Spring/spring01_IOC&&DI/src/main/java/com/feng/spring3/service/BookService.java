package com.feng.spring3.service;

import com.feng.spring3.bean.Book;
import com.feng.spring3.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book> {
}
