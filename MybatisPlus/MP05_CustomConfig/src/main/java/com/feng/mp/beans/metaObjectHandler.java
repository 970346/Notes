package com.feng.mp.beans;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义的公共字段
 */
public class metaObjectHandler extends MetaObjectHandler {
    /**
     * <p>
     * 插入元对象字段填充
     * </p>
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取需要被填充的字段的值
        Object fieldValue = getFieldValByName("name",metaObject);
        if (fieldValue == null){
            System.out.println("*************插入操作 满足填充条件***************");
            setFieldValByName("name","zxvz",metaObject);
        }
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     * Created with IntelliJ IDEA.
     * Author:  Wu Yujie
     * Email:  coffee377@dingtalk.com
     * Time:  2017/04/16 15:03
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object fieldValue = getFieldValByName("name",metaObject);
        if (fieldValue == null){
            System.out.println("*************修改操作 满足填充条件***************");
            setFieldValByName("name","zx",metaObject);
        }
    }
}
