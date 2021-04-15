package com.xiayu.performance;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
    public static void main(String[] args) {

        List<Object> objects1 = Lists.newArrayList();
        Date date = new Date();
        for (int i = 0; i < 1000000; i++) {
            List<String> objects = new ArrayList<>();
            objects.add("123");
            objects1.add(objects);
            HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
            objects1.add(objectObjectHashMap);
        }
        System.out.println("" + getInterval(date, new Date()));
        objects1.clear();
    }

    public static float getInterval(Date begin, Date end) {
        return (float) (end.getTime() - begin.getTime()) / 1000;
    }
}
