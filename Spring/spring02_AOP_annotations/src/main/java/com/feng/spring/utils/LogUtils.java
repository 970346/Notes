package com.feng.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)   //多切面时设定顺序
public class LogUtils {
    /**
     * 抽取可重用的切入点表达式
     * 1、写一个空方法
     * 2、给方法上标注@Pointcut注解
     */
    @Pointcut("execution(public int com.feng.spring.inter.impl.MyMathCalculator.add(int,int))")
    public void hahamypoint(){}

    /**
     * 环绕通知
     *
     */
    @Around("hahamypoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        //利用反射调用目标方法即可，就是method.invoke(obj,args)
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

    /**
     * 告诉spring每个方法什么时候进行
     * @Before：在目标方法之前运行                前置通知
     * @After：在目标方法结束之后                 后置通知
     * @AfterReturning：在目标方法正常返回之后   返回通知
     * @AfterThrowing：在目标方法抛出异常之后    异常通知
     *                                              环绕通知
     */

    /**
     * 想在执行目标方法之前运行
     * 写切入点表达式
     *
     * JoinPoint joinPoint：封装了当前目标方法的详细信息
     */
    @Before("hahamypoint()")
    public static void logStart(
            JoinPoint joinPoint
//            Method method,Object... objects
    ){
        //获取目标方法的方法签名
        Signature signature = joinPoint.getSignature();
        //拿到方法名
        String name = signature.getName();
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LogUtils的【"+name+"】方法开始了，用的参数列表【"+ Arrays.asList(args) +"】");
//        System.out.println("【"+method.getName()+"】方法开始执行，用的参数列表【"+ Arrays.asList(objects) +"】");
    }
    /**
     * 想在执行目标方法正常执行运行
     */
    @AfterReturning(value = "hahamypoint()",returning="result")
    public static void logReturn(
            JoinPoint joinPoint,Object result
//            Method method,Object result
    ){
        //获取目标方法的方法签名
        Signature signature = joinPoint.getSignature();
        //拿到方法名
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法正常执行完成，计算结果为"+result);
//        System.out.println("【"+method.getName()+"】方法正常执行完成，计算结果为"+result);
    }
    /**
     * 想在执行目标方法出现异常时运行
     */
    @AfterThrowing(value = "hahamypoint()",throwing = "e")
    public static void logException(
            JoinPoint joinPoint,Exception e
//            Method method, Exception e
    ) {
        //获取目标方法的方法签名
        Signature signature = joinPoint.getSignature();
        //拿到方法名
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法执行出现异常，异常信息为"+e+"这个异常已经通知测试小组进行排查");
    }
    /**
     * 想在执行目标方法完成运行
     */
    @After("hahamypoint()")
    public static void logEnd(
            JoinPoint joinPoint
//            Method method
    ) {
        //获取目标方法的方法签名
        Signature signature = joinPoint.getSignature();
        //拿到方法名
        String name = signature.getName();
        System.out.println("LogUtils的【"+name+"】方法最终结束了");
    }
}
