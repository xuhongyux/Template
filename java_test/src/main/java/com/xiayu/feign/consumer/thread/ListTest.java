package com.xiayu.feign.consumer.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-06-17 17:05
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        objects.add(0);
        new Thread(
                () ->{
                    for(int i =0 ; i<1001; i++){
                        Integer integer = objects.get(0);
                        integer++;
                        objects.clear();
                        objects.add(integer);

                    }

                }

        ).start();
        new Thread(
                () ->{
                    for(int i =0 ; i<1001; i++){
                        Integer integer = objects.get(0);
                        integer++;
                        objects.clear();
                        objects.add(integer);

                    }
                }

        ).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(objects.get(0));
    }
}
