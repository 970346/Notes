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

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee=new Employee(1,"Admin",null,null);
//            List<Employee> employees = mapper.getEmpsByConditionIf(employee);
//            List<Employee> employees = mapper.getEmpsByConditionTrim(employee);
//            List<Employee> employees = mapper.getEmpByConditionChoose(employee);
//            for (Employee e:employees
//                 ) {
//                System.out.println(e);
//            }
//            mapper.updateEmp(employee);
//            openSession.commit();
            List<Employee> employees = mapper.getEmpsByConditionForeach(Arrays.asList(1, 3, 4, 5));
            for (Employee e:employees) {
                System.out.println(e);
            }
        }
        finally {
            openSession.close();
        }
        /*  查询的时候如果某些条件没带值可能sql拼装会有问题
            1.给where后面加上1=1，以后的条件都and xxx
            2.mybatis使用where标签来将所有的条件包括在内.mybatis就会将where标签中拼装的sql，多出来的and或者or自动去掉。
                where只会去掉第一个多出的and或者or
        * */
    }

    @Test
    public void testBatchSave() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null,"smith","smith@qq.com","1" ,new Department(1)));
            emps.add(new Employee(null,"allen","smith@qq.com","0" ,new Department(1)));
            mapper.addEmps(emps);
            openSession.commit();
        }finally {
            openSession.close();
        }
    }
}
