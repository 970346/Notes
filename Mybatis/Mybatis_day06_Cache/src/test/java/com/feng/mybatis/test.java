package com.feng.mybatis;

import com.feng.mybatis.Bean.Department;
import com.feng.mybatis.Bean.Employee;
import com.feng.mybatis.Dao.DepartmentMapper;
import com.feng.mybatis.Dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /*
        两级缓存
        一级缓存（本地缓存）：sqlSession级别的缓存。一级缓存是一直开启。
            作用：与数据库同一次会话期间查询到的数据会放在本地缓存中，以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库
            一级缓存失效的情况（没有使用到当前一级缓存的情况，效果就是还需要向数据库发出sql语句）:
                1、sqlSession不同
                2、sqlSession相同，sql语句不同。
                3、sqlSession相同，在两次相同的sql语句中，执行了其他sql语句
                4、sqlSession相同，手动清除了一级缓存（缓存清空）

        二级缓存（全局缓存）：基于namespace级别的缓存。
            工作流程：1、一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中
                  2、如果会话关闭了，一级缓存中的数据会被保存到二级缓存中，新的会话查询信息，就可以参照二级缓存中的内容
                  3、sqlSession有多个mapper查询出来的多个mapper对象，不同的namespace查出的数据会放在自己对应的mapper中
            使用流程：1、开启全局二级缓存配置：<setting name="cacheEnabled" value="true"/>
                      2、在mapper.xml中配置使用二级缓存：<cache></cache>
                      3、pojo需要实现序列化接口
            效果：数据会从二级缓存中去，查出的数据都会被默认先放在一级缓存中，只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中
            相关设置/属性：
                1、cacheEnable：false,关闭了二级缓存，一级缓存仍然可以用
                2、每个selec标签都有useCache。
                    true：针对二级缓存使用
                    false：不影响一级缓存的使用，二级缓存不使用
                3、每个增删改标签都有flushCache。
                    true：一级缓存和二级缓存都会被清空
                    查询标签的flushCache默认为false，如果改为true则每次查询前都会清空缓存，缓存是没有被使用的。
                4、sqlSession.clearCache()只能清除当前sqlSession的一级缓存
                5、localCacheScope：本地缓存作用域：
                    SESSION：一级缓存，当前会话的所有数据保存在会话缓存中；
                    STATEMENT：禁用一级缓存
    * */

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
//            SqlSession openSession2 = sqlSessionFactory.openSession(true);
//            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
//            Employee emp1 = mapper2.getEmpById(1);

//            Employee employee = new Employee(null, "testCache", "cache", "1");
//            mapper.addEmp(employee);
//            System.out.println("添加数据成功");
            openSession.clearCache();
            Employee emp1 = mapper.getEmpById(3);
            System.out.println(emp1);
            System.out.println(emp==emp1);
//            openSession2.close();
        }
        finally {
            openSession.close();
        }
    }

    @Test
    public void testCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        SqlSession openSession2 = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
            openSession.close();
            //第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
            Employee emp2 = mapper2.getEmpById(1);
            System.out.println(emp2);
            openSession2.close();
        }finally {

        }
    }

    /**
     * 第三方缓存整合：
     *  1、导入第三方缓存包
     *  2、导入与第三方缓存整合的适配包
     *  3、mapper.xml中使用自定义缓存
     *      <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
     *
     */
}
