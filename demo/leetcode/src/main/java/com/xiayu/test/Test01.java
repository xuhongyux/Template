package com.xiayu.test;


import com.xiayu.thread.OrderRun;
import com.xiayu.thread.PrintFooBar;
import org.junit.Test;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-23-10:49
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        OrderRun orderRun = new OrderRun();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        Runnable a = () -> {
            try {
                orderRun.second(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(a).start();

        Runnable aa = () -> {
            try {
                orderRun.first(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(aa).start();

    }

    @Test
    public void printFooBarTest() throws InterruptedException {
        PrintFooBar printFooBar = new PrintFooBar(2);



        new Thread(
                () -> {
                    try {
                        printFooBar.bar(
                                () ->{
                                    System.out.println("bar");
                                });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        Thread.sleep(2000);

        printFooBar.foo(
                () -> {
                    System.out.print("foo");
                }
        );


    }

}

