package com.xiayu.factory;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-20-14:02
 */
public class PlaneFactory implements MFactory {
    @Override
    public Plane creat(){
        Plane plane = new Plane();
        plane.setName("Super Plane");
        return plane;
    }
}
