package com.feng.spring.factory;

import com.feng.spring.bean.AirPlane;

/**
 * 静态工厂
 */
public class AirPlaneStaticFactory {
    public static AirPlane getAirPlane(String jzName){
        System.out.println("静态工厂飞机");
        AirPlane plane = new AirPlane();
        plane.setFdj("太行");
        plane.setFjsName("lfy");
        plane.setJzName(jzName);
        plane.setPersonNum(300);
        plane.setYc("198.98m");
        return plane;
    }
}
