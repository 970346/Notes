package com.feng.mybatis;

import com.feng.mybatis.Bean.Employee;
import com.feng.mybatis.Dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1、接口式编程
 * 原生 ：        DAO     ====>   DaoImpl
 * mybaits：      Mapper  ====>   xxMapper.xml
 * 2、SQLSession代表和数据库的一次会话，用完必须关闭
 * 3、SQLSession和Connection一样都是非线程安全。每次使用都应该去获取新的对象
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
 * （将接口和xml进行绑定）
 * EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统环境信息
 * sql映射文件：保存了每一个sql语句的映射信息
 */
public class MyBatisTest {
    /**
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 有数据源一些运行环境信息
     * 2、sql映射文件：配置了每一个sql，以及sql的封装规则等。
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码：
     * 1）、根据全局配置文件得到SqlSessionFactory
     * 2）、使用SqlSession工厂，获取到SqlSession对象使用它来执行增删改查操作
     * 一个SqlSession就是代表和数据库的一次会话，用完需要关闭。
     * 3）、使用sql的唯一标识来告诉Mybatis执行哪个sql。sql都是保存在映射文件之中
     **/
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        /*
        获取SqlSession实例，能直接执行已经映射的sql语句
        s：sql的唯一标识(namespace+id)
        o：执行sql要用的参数
        * */
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {

            Employee employee = openSession.selectOne("com.feng.mybatis.Bean.Employee.selectEmp", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        } finally {
            openSession.close();
        }
    }
}
