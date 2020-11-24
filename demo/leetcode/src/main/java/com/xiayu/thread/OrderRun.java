package com.xiayu.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuhongyu
 * <p>
 * 1114. 按序打印
 * @describe 一个实体类有三个方法，现在创建一个实例，用不同的线程调用这个实例的三个方法，三个方法的顺序不变。
 * @create 2020-11-23-9:59
 */
public class OrderRun {

    private final AtomicInteger integer = new AtomicInteger(0);

    public void first(Runnable printFirst) {
        printFirst.run();
        integer.incrementAndGet();
        System.out.println("first");
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (integer.get() < 1) {
        }
        printSecond.run();
        System.out.println("second");
        integer.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (integer.get() < 2) {
        }
        printThird.run();
        System.out.println("third");
    }

    public String getTest(){
        return "";
    }


    public static void main(String[] args) throws InterruptedException {
        OrderRun orderRun = new OrderRun();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        new Thread(orderRun.getTest()).start();
        orderRun.second(runnable);

    }
}


class Foo {
    public void first() {
        System.out.println("first");
    }

    public void second() {
        System.out.println("second");
    }

    public void third() {
        System.out.println("third");
    }
}


