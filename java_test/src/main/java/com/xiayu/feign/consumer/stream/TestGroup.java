package com.xiayu.feign.consumer.stream;

import org.testng.collections.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @create 2021-07-21 17:11
 */
public class TestGroup {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("许");
        objects.add("123");
        objects.add("xiayu");
        objects.add("123");
        objects.add("xiayu");
        objects.add("许");
        objects.add("xiayu");
        objects.add("xiayu");
        objects.add("许");
        objects.add("xiayu");
        objects.add("xiayu");
        objects.add("许");
        objects.add("xiayu");
        objects.add("xiayu");
        objects.add("许");
        objects.add("xiayu");
        objects.add("许");
        objects.add("xiayu");

        Map<String, Integer> objectObjectMap = Maps.newConcurrentMap();
        for (String object : objects) {

            if (objectObjectMap.containsKey(object)) {
                Integer integer = objectObjectMap.get(object);
                integer++;
                objectObjectMap.put(object,integer);
            }else {
                objectObjectMap.put(object,1);
            }
        }

        System.out.println();
    }


}
