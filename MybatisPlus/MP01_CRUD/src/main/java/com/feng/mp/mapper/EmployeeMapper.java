package com.feng.mp.mapper;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.mp.beans.Employee;

/**
 * Mapper接口
 *
 * mybatis：在Mapper接口中编写crud相关的方法，提供Mapper接口所对应的SQL映射文件以及方法对应的SQL语句
 * mybatis-plus：让Mapper接口集成BaseMapper接口即可，泛型为当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
}
