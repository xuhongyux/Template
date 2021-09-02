package com.xiayu.feign.consumer.thread;

/**
 * @author xuhongyu
 * @describe
 *
 *  1115 交替打印FooBar
 *
 *
 * @create 2020-11-24-10:52
 */
public class PrintFooBar {
    private int n;

    private boolean fooFlag = false;
    private boolean barFlag = true;
    Object lock = new Object();

    public PrintFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                while(fooFlag){
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooFlag = true;
                barFlag = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                while(barFlag){
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooFlag = false;
                barFlag = true;
                lock.notifyAll();
            }

        }
    }

}
