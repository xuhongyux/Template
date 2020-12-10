package com.xiayu.proxy.v10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
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
 * v7如果有stop发放需要代理...
 * 如果想让logProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型
 * （毕竟日志记录，时间计算是很多方法需要的东西）,这时该怎么做呢？
 * 分类代理行为与代理对象
 * 使用jdk的动态代理
 * 多方法代理
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

    @Override
    public void move2() {
        System.out.println("Tank moving2 cacaca...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Tank tank = new Tank();
        //reflection 通过二进制字节码分享类的属性和方法
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                Tank.class.getInterfaces(),//
                new TimeProxy(tank));

        Method[] methods = Movable.class.getMethods();

        System.out.println(Arrays.toString(methods));
        for (Method method : methods) {
            method.invoke(m);
        }
    }
}

class TimeProxy implements InvocationHandler {
    Tank tank;

    public TimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("move")) {
            before();
        } else if (method.getName().equals("move2")) {
            beforeTime();
        }
        Object o = method.invoke(tank, args);
        if (method.getName().equals("move")) {
            after();
        } else if (method.getName().equals("move2")) {
            afterTime();
        }
        return o;
    }

    private void after() {
        System.out.println("method end..");
    }

    private void before() {
        System.out.println("method start..");
    }

    private void afterTime() {
        System.out.println(System.currentTimeMillis());
    }

    private void beforeTime() {
        System.out.println(System.currentTimeMillis());
    }
}

interface Movable {
    void move();

    void move2();
}