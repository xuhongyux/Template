package com.xiayu.design.patterns.template.javatest;

import com.xiayu.design.patterns.template.po.Father;
import com.xiayu.design.patterns.template.po.Man;

/**
 * @author xuhongyu
 * @create 2021-12-08 5:11 下午
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Man father = new Father();
        father.setName("123");

        System.out.println(father.getName());
    }

}
