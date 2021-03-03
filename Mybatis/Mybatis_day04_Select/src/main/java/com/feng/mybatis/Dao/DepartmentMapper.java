package com.feng.mybatis.Dao;

import com.feng.mybatis.Bean.Department;

public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    public Department getDeptByIdPluus(Integer id);

    Department getDeptByIdStep(Integer deptId);
}
