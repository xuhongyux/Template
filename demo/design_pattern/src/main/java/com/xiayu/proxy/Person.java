package com.xiayu.proxy;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-20-17:21
 */
public class Person implements IPerson{
    @Override
    public void eat() {
        System.out.println("我在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("我在睡觉");
    }
}
