package com.feng.spring3.dao;

import com.feng.spring3.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void save() {
        System.out.println("保存了图书。。。");
    }
}
