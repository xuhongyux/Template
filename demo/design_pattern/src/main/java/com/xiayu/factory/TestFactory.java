package com.xiayu.factory;

import org.junit.Test;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-20-13:01
 */

public class TestFactory {
//    public static void main(String[] args) {
//        MoveFactory m  =  new MoveFactory();
//        Car car = (Car) m.creatMove("car");
//        System.out.println(car.getName());
//        Plane plane = (Plane) m.creatMove("plane");
//        System.out.println(plane.getName());
//    }
    @Test
    public void planeFactoryTest(){
        PlaneFactory planeFactory = new PlaneFactory();
        Plane plane = planeFactory.creat();
        System.out.println(plane.getName());

    }
}
