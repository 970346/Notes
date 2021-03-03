package com.feng.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BValidateApsect {
    @Before("com.feng.spring.utils.LogUtils.hahamypoint()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法开始了，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    @AfterReturning(value = "com.feng.spring.utils.LogUtils.hahamypoint()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法正常执行完成，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    @AfterThrowing(value = "com.feng.spring.utils.LogUtils.hahamypoint()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法执行出现异常，用的参数列表【"+ e +"】");
    }
    @After("com.feng.spring.utils.LogUtils.hahamypoint()")
    public void logEnd(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("ValidateApsect的【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }
}
