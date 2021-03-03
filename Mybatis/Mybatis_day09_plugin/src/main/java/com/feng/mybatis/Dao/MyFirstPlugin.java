package com.feng.mybatis.Dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;
/*
    完成插件签名：告诉mybatis当前插件用来拦截哪个对象的哪个方法
    type:指定拦截四大对象中的哪一个
    method:指定拦截对象中的哪一个方法
    args:指定当前方法的参数列表
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args=java.sql.Statement.class)})
public class MyFirstPlugin implements Interceptor {

    /**
     * intercept:拦截
     *      拦截目标对象的目标方法的执行
     */
    @Override
    public java.lang.Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin-------------intercept："+invocation.getMethod());
        //动态的改变一下sql运行的参数
        Object target = invocation.getTarget();
        System.out.println("当前被拦截到的对象："+invocation.getTarget());
        //获取StatementHandler-->ParameterHandler-->parameterObject
        //获取target的原数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数时："+value);
        //修改sql语句要用的参数
        metaObject.setValue("parameterHandler.parameterObject",11);
        //执行目标方法
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    /**
     * 包装目标对象：为目标对象创建一个代理对象
     */
    @Override
    public java.lang.Object plugin(java.lang.Object target) {
        System.out.println("MyFirstPlugin-------------plugin：mybatis将要包装的对象"+target);
        //借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(target, this);
        //返回为当前target动态代理
        return wrap;
    }

    /**
     * 将插件注册时的property属性设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }
}
