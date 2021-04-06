package com.xiayu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xuhongyu
 * @describe  线程的创建
 * @create 2021-01-28-17:27
 */
public class CreatThread {

    public static void main(String[] args) {
        ThreadTest thread = new ThreadTest();
        thread.start();
        System.out.println("主线程运行-1");


        RunnableTest runnableTest = new RunnableTest();
        Thread thread1 = new Thread(runnableTest);
        thread1.start();
        System.out.println("主线程运行-2");


        //创建新线程线程有返回值
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("主线程运行-3");

    }
}

/**
 * 继承Thread
 */
class ThreadTest extends Thread{
    @Override
    public void run(){
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("继承Thread");
    }
}

/**
 * 实现 Runnable
 */
class RunnableTest implements  Runnable{

    @Override
    public void run() {
        try {
            // 睡两秒
            Thread.sleep(2222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("实现 Runnable");
    }
}

class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Raymond");
        return "Hello Raymond !";
    }
}
