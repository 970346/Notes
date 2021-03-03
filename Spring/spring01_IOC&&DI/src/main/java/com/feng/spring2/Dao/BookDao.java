package com.feng.spring2.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    public void saveBook(){
        System.out.println("图书已经保存了");
    }
}
