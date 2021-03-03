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

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
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
    /**
     * 插件原理
     * 在四大对象创新的时候
     * 1、每个创建出来的对象不是直接返回的，二十interceptorChin.pluginAll(parameterHandler);
     * 2、获取到所有的Intercepter(拦截器)(插件需要的接口)，调用intercepter.plugin(target);返回target包装后的对象
     * 3、插件机制，我们可以使用插件为目标对象创建一个代理对象；AOP（面向切面）
     *      插件可以为四大对象创建出代理对象；代理对象可以拦截四大对象的每一个方法
     *
     *    public Object pluginAll(Object target){
     *        for(Interceptor interceptor:interceptors){
     *            target=intercepter.plugin(target);
     *        }
     *    }
     */

    /**
     * 编写插件：
     * 1、编写Interceptor的实现类
     * 2、使用Intercepts注解完成插件签名
     * 3、将写好的插件注册到全局配置文件中
     */
    @Test
    public void testPlugin(){

    }
}
