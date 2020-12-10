package com.xiayu.proxy.v5;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法，修改代码，记录时间
 * 问题2:如果无法改变方法源码呢？ benchmark--性能测试
 * 用继承？
 * 使用代理
 * 代理各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator?
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
        new TankLongProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {
    Tank tank;

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }
}

class TankLongProxy implements Movable {
    Tank tank;

    @Override
    public void move() {
        System.out.println("start moving...");
        tank.move();
        System.out.println("stopped");
    }

    public TankLongProxy(Tank tank) {
        this.tank = tank;
    }
}

interface Movable {
    void move();
}