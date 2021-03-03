package com.feng.spring.proxy;

import com.feng.spring.inter.Calculator;
import com.feng.spring.utils.LogUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 生成代理对象
 */
public class CalculatorProxy {
    /**
     * 为传入的参数对象创建一个动态代理对象
     */
//    public static Calculator getProxy(final Calculator calculator) {
        /***
         * 目标方法执行器，帮助目标对象执行目标方法
         */
//        InvocationHandler h = new InvocationHandler() {
            /**
             * @param proxy：代理对象，由jdk使用，一般我们不改变
             * @param method：当前将要执行的目标对象的方法
             * @param args：方法调用时外界传入的参数值
             * @return
             * @throws Throwable
             */
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object result = null;
////                System.out.println("动态代理的执行方法");
//                try {
//                    LogUtils.logStart(method,args);
//                    //利用反射执行目标方法
//                    result = method.invoke(calculator, args);
//                    LogUtils.logReturn(method,result);
//                } catch (Exception e) {
//                    LogUtils.logException(method,e);
//                }finally {
//                    LogUtils.logEnd(method);
//                }
//                return result;
//            }
//        };
        /**
         * 对象实现的接口
         */
//        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        /**
         * 被代理对象的类加载器
         */
//        ClassLoader loader = calculator.getClass().getClassLoader();
        //Proxy为目标对象创建代理对象
//        Object proxy = Proxy.newProxyInstance(loader,interfaces,h);
//        return (Calculator) proxy;
//    }
}
