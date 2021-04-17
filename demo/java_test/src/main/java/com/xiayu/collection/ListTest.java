package com.xiayu.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-04-16 18:32
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        list1.set(1,"s");
        System.out.println(list1);

    }
}
