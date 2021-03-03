package com.feng.spring.factory;

import com.feng.spring.bean.AirPlane;

/**
 * 实例工厂
 */
public class AirPlaneInstanceFactory {
    public AirPlane getAirPlane(String jzName){
        System.out.println("实例工厂飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("198.98m");
        return airPlane;
    }
}
