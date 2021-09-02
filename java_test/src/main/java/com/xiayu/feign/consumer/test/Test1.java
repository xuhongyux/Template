package com.xiayu.feign.consumer.test;

import com.beust.jcommander.internal.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @create 2021-05-23 14:07
 */
public class Test1 {
    public static void main(String[] args) {

        Test test = new Test();
       int b =  test.a;
        List<String> stringList = Lists.newArrayList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("7");
        stringList.add("8");

        List<Integer> collect = stringList.stream().map(po -> {
            return Integer.parseInt(po);
        }).collect(Collectors.toList());

        System.out.println(collect);
    }
}
