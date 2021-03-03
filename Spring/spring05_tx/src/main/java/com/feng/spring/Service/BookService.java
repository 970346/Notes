package com.feng.spring.Service;

import com.feng.spring.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    /**
     * Isolation isolation()：事务的隔离级别
     * Propagation propagation()：事务的传播行为
     *
     * Class<? extends Throwable>[] noRollbackFor()：哪些异常事务不可以回滚
     *  作用：使原来回滚的异常不回滚
     * String[] noRollbackForClassName()：异常全类名
     *
     * Class<? extends Throwable>[] rollbackFor()：哪些异常事务需要回滚
     *  作用：使原来不回滚的异常回滚
     * String[] rollbackForClassName()：异常全类名
     *
     * 异常分类：
     *  运行异常：可不用处理，默认都会回滚
     *  编译异常：必须处理，默认不回滚
     *
     *
     * boolean readOnly()：设置事务为只读事务
     *      作用：可以进行事务优化
     *          值true时：加快查询速度，不用管事务的操作。
     * int timeout()：事务超出指定执行时长后自动终止并回滚，秒为单位
     */
    @Transactional(timeout = 3,noRollbackFor = {ArithmeticException.class,NullPointerException.class})
    public void checkout(String usernmae,String isbn) throws FileNotFoundException {
        //1.减库存
        bookDao.updateStock(isbn);
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int price = bookDao.getPrice(isbn);
        //2.减余额
        bookDao.updateBalance(usernmae,price);
        int i=10/0;
        //new FileInputStream("D://asda.aa");
    }
}
