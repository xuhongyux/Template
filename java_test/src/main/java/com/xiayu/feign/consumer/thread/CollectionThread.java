package com.xiayu.feign.consumer.thread;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author xuhongyu
 * @describe 容器线程
 * @create 2021-01-29-10:26
 */
public class CollectionThread {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        Collections.synchronizedCollection(objects);

        new Thread(
                () ->{
                    for(int i =0 ; i<100; i++){
                        objects.add(i);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        ).start();


        new Thread(
                () ->{
                    for(int i =0 ; i<100; i++){
                        objects.add(i+"String");
                    }
                }

        ).start();


        Thread.sleep(3000);

        System.out.println(objects.toArray().toString());
    }
}
