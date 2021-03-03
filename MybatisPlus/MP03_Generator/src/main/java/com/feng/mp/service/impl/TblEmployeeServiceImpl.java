package com.feng.mp.service.impl;

import com.feng.mp.beans.TblEmployee;
import com.feng.mp.mapper.TblEmployeeMapper;
import com.feng.mp.service.TblEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feng
 * @since 2020-04-02
 */
@Service
public class TblEmployeeServiceImpl extends ServiceImpl<TblEmployeeMapper, TblEmployee> implements TblEmployeeService {
    //不需要再进行mapper注入
}
