package com.feng.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class BValidateApsect {
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法开始了，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    public void logReturn(JoinPoint joinPoint,Object result){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法正常执行完成，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    public void logException(JoinPoint joinPoint,Exception e){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法执行出现异常，用的参数列表【"+ e +"】");
    }
    public void logEnd(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }
}
