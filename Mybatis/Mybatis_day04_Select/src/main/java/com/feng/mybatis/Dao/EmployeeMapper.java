package com.feng.mybatis.Dao;

import com.feng.mybatis.Bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //查询返回list
    public List<Employee> getEmpsByLastNameLike(String lastName);
    //返回单条记录的map：key就是列名，值就是对应的值
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
    //多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
    //通过MapKey注解告诉mybatis封装这个map时使用哪个属性作为map的主键
    @MapKey("id")
    public Map<Integer,Employee> getEmpsByLastNameLikeReturnMap(String lastName);

    public Employee getEmpById(Integer id);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public List<Employee> getEmpByDeptId(Integer id);
}
