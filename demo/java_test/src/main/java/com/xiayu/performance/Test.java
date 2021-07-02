package com.xiayu.performance;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @create 2021-04-07 11:20
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {

        Enter();
        Thread.sleep(5000);
        List<Double> objects1 = Lists.newArrayList();
        Date date = new Date();
        for (int i = 0; i < 999999; i++) {
            objects1.add(10000000000009999999999956756756756D);
        }
        double sum = objects1.stream().mapToDouble(po -> po).sum();
        System.out.println("" + getInterval(date, new Date()));
        System.out.println(sum);

        objects1.clear();
    }

    public static float getInterval(Date begin, Date end) {
        return (float) (end.getTime() - begin.getTime()) / 1000;
    }



    public static void Enter() throws IOException {//停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }


}
