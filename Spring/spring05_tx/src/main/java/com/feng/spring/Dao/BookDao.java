package com.feng.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 减余额
     */
    public void updateBalance(String userName,int price){
        String sql = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    /**
     * 获取图书价格
     */
    public int getPrice(String isbn){
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    /**
     * 减库存
     */
    public void updateStock(String isbn){
        String sql = "update book_stock set stock=stock-1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }
}
