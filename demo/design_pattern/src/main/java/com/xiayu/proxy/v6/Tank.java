package com.xiayu.proxy.v6;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法，修改代码，记录时间
 * 问题2:如果无法改变方法源码呢？ benchmark--性能测试
 * 用继承？
 * v4使用代理
 * v5代理各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator?
 * v6代理的对象改成Movable类型--越来越想decorator了
 */
public class Tank implements Movable {
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {


        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable {
    Movable movable;

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }
}

class TankLogProxy implements Movable {
    Movable movable;

    @Override
    public void move() {
        System.out.println("start moving...");
        movable.move();
        System.out.println("stopped");
    }

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }
}

interface Movable {
    void move();
}