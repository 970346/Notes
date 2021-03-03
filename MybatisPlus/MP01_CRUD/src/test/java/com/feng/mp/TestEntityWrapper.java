package com.feng.mp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.feng.mp.beans.Employee;
import com.feng.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestEntityWrapper {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 条件构造器 删除操作
     * */
    @org.junit.Test
    public void testEntityWrapperDelete(){
        /*删除名字为Toms并且年龄为40*/
        employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name","Toms")
                .eq("age",40));
    }

    /**
     * 条件构造器 修改操作
     * */
    @org.junit.Test
    public void testEntityWrapperUpdate(){
        /*修改名字为Toms，并且年龄为45*/
        Employee employee = new Employee();
        employee.setLastName("ti");
        employee.setEmail("s@qq.com");
        employee.setGender(0);
        Integer update = employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                        .eq("last_name", "Toms")
                        .eq("age", 45));
        System.out.println(update);
    }

    /**
     * 条件构造器 查询操作
     * */
    @org.junit.Test
    public void testEntityWrapperSelect(){
        /*分页查询：年龄18-50之间，性别为男且姓名为xxx的所有用户*/
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2),
                Condition.create().between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "Toms"));
//        List<Employee> employees = employeeMapper.selectPage(new Page<>(1, 2),
//                new EntityWrapper<Employee>()
//                        .between("age", 18, 50)
//                        .eq("gender", 1)
//                        .eq("last_name", "Toms"));
//        for (Employee e : employees) {
//            System.out.println(e);
//        }
        /*查询性别为女，且名字中带有“老师”或者邮箱中带有“a”*/
        /*
        or:SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee
                WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
        orNew:SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee
                WHERE (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
        * */
//        List<Employee> employees = employeeMapper.selectList(
//                new EntityWrapper<Employee>()
//                        .eq("gender", 0)
//                        .like("last_name", "老师")
//                        .orNew().like("email", "a")
//        );
        /*查询性别为女，根据age进行排序，简单分页*/
        /*orderBy:默认为升序
         * */
//        List<Employee> employees = employeeMapper.selectList(
//                new EntityWrapper<Employee>().eq("gender", 0)
////                      .orderDesc(Arrays.asList(new String[] {"age"}))
//                        .orderBy("age")
//                        .last("desc limit 1,3")   //有SQL注入风险
//
//        );
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
