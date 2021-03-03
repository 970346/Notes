package com.feng.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.Version;

/**
 * 定义javabean中成员变量时所使用的类型：
 *  因为每个基本类型都有一个默认值：
 *      int ==> 0
 *      boolean ==> false
 *
 * 原因：有些框架中的方法会判断变量是否为空！
 */

/***
 * mybatisplus会默认使用实体类的类名到数据中找对应的表
 * 可通过@TableName注解指定数据库中的表名
 *  value:指定实体类对应数据库中表的表名
 *  type:高级查询的返回结果集
 */
//@TableName(value = "tbl_employee")
public class Employee {
    /**
     *  @TableId:
     *      value:指定表中的主键列的列名，如果实体属性名与列名一直，可以省略不指定
     *      type:指定主键策略
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
    @Version
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}