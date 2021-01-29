package com.xiayu.thread;

import com.xiayu.utils.ThreadPoolUtil;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xuhongyu
 * @describe 线程池
 * @create 2021-01-29-10:50
 */
public class ThreadPool {

    public static void main(String[] args) {


        ThreadPoolUtil.execute(
                () ->{

                }

        );





//        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
//        //以固定得频率执行这个任务
//        service.scheduleAtFixedRate(() -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName());
//        }, 0, 500, TimeUnit.MILLISECONDS);

    }
}
