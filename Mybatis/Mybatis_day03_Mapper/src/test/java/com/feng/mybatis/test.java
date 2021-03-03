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
import java.util.HashMap;
import java.util.Map;

public class test {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1、mybatis允许增删改直接定义以下返回值
     *      Integer、Long、Boolean
     * 2、手动提交数据
     *      sqlSessionFactory.openSession============>手动提交
     *      sqlSessionFactory.openSession(true)======>自动提交
     */
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//            添加
//            Employee employee=new Employee(null,"jerry","jerry@qq.coom","1");
//            mapper.addEmp(employee);
//            System.out.println(employee.getId());

            //更新
//            Employee employee2=new Employee(1,"tom","jerry@qq.coom","1");
//            boolean updateEmp = mapper.updateEmp(employee2);
//            System.out.println(updateEmp);

            /*删除
                mapper.deleteEmpById(2);
            */

            //查询
//            Employee emp = mapper.getEmpByIdAndLastName("1", "tom");
            Map<String,Object> map = new HashMap<>();
            map.put("id",1);
            map.put("lastname","tom");
            map.put("tableName","tbl_employee");
            Employee emp = mapper.getEmpByMap(map);
            System.out.println(emp);

        } finally {
            openSession.close();
        }
    }
}
