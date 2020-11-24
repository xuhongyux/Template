package com.xiayu.factory;

/**
 * @describe 交通工具工厂类
 * @author xuhongyu
 * @create 2020-11-20-12:53
 */
public class MoveFactory {
    public Object creatMove(String moveName){
        switch (moveName){
            case "car" : return new Car();
            case "plane": return new Plane();
            default: throw new IllegalArgumentException("没有这种交通工具");
        }
    }
}
