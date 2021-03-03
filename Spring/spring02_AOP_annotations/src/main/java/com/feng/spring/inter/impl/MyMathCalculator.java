package com.feng.spring.inter.impl;

import com.feng.spring.inter.Calculator;
import com.feng.spring.utils.LogUtils;
import org.springframework.stereotype.Service;

@Service
public class MyMathCalculator /*implements Calculator */{
    //@Override
    public int add(int i, int j) {
//        LogUtils.logStart(i, j);
        int result = i + j;
        System.out.println("方法内部执行");
//        System.out.println("【add】方法运行完成，运算结果是：【" + result + "】");
        return result;
    }

    //@Override
    public int sub(int i, int j) {
        /*LogUtils.logStart(i, j);*/
        int result = i - j;
        /*System.out.println("【sub】方法运行完成，运算结果是：【" + result + "】");*/
        return result;
    }

    //@Override
    public int mul(int i, int j) {
//        LogUtils.logStart(i, j);
        int result = i * j;
//        System.out.println("【mul】方法运行完成，运算结果是：【" + result + "】");
        return result;
    }

    //@Override
    public int div(int i, int j) {
//        LogUtils.logStart(i, j);
        int result = i / j;
//        System.out.println("【div】方法运行完成，运算结果是：【" + result + "】");
        return result;
    }
}
