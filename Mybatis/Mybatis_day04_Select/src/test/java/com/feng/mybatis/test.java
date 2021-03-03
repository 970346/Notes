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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//            List<Employee> map = mapper.getEmpsByLastNameLike("%e%");

//            Map<String, Object> map = mapper.getEmpByIdReturnMap(1);

//            Map<Integer, Employee> map = mapper.getEmpsByLastNameLikeReturnMap("%r%");

//            Employee map = mapper.getEmpById(3);

//            Employee map = mapper.getEmpAndDept(3);

//            Employee map = mapper.getEmpByIdStep(1);
//            System.out.println(map.getLastName());
//            System.out.println(map.getDept());
            Employee nmap = mapper.getEmpByIdStep(1);
            System.out.println(nmap);
            Employee wmap = mapper.getEmpByIdStep(4);
            System.out.println(wmap);
            System.out.println(wmap.getDept());
        } finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
//            Department department = mapper.getDeptByIdPluus(1);
            Department department = mapper.getDeptByIdStep(1);
            System.out.println(department.getId());
            System.out.println(department.getEmployees());
        } finally {
            openSession.close();
        }
    }
}
