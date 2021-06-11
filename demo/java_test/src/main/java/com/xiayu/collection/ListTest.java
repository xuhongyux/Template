package com.xiayu.collection;

import com.beust.jcommander.internal.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-04-16 18:32
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("9");
        stringList.add("9");
        stringList.add("9");
        stringList.add("9");
        stringList.add("9");
        stringList.add("9");

        boolean remove = stringList.remove("9");
        System.out.println(stringList);


    }
}
