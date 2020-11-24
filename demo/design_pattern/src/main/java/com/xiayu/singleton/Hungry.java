package com.xiayu.singleton;

/**
 * @author xuhongyu
 * @describe  饿汉式  变量声明前初始化
 * @create 2020-11-20-14:35
 */
public class Hungry {
    private static Hungry instance= new Hungry();

    private Hungry(){

    }
    public static Hungry getHungry(){
        return instance;
    }
}
