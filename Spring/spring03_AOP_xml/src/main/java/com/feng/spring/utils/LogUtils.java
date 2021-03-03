package com.feng.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class LogUtils {
    /**
     * 环绕通知
     *
     */
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知"+pjp.getSignature().getName()+"方法开始");
            proceed = pjp.proceed(args);
            System.out.println("环绕返回通知"+pjp.getSignature().getName()+"方法返回，返回值为"+proceed);
        } catch (Exception e) {
            System.out.println("环绕异常通知"+pjp.getSignature().getName()+"方法异常，异常信息为"+e);
            throw new RuntimeException(e);
        }finally {
            System.out.println("环绕后置通知"+pjp.getSignature().getName()+"方法完成");
        }
//        System.out.println("环绕哈哈");
        //反射调用后的返回值也一定返回
        return proceed;
    }

    public static void logStart(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LogUtils的【"+name+"】方法开始了，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    public static void logReturn(JoinPoint joinPoint,Object result
    ){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法正常执行完成，计算结果为"+result);
    }
    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法执行出现异常，异常信息为"+e+"这个异常已经通知测试小组进行排查");
    }
    public static void logEnd(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法最终结束了");
    }
}
