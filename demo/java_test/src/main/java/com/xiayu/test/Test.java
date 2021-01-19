package com.xiayu.test;

import com.xiayu.admin.Root;
import com.xiayu.admin.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-12-18:48
 */
public class Test {
    public static void main(String[] args) throws  Exception{
        Class<?> aClass = Class.forName("com.xiayu.admin.User");
        User o = (User) Class.forName("com.xiayu.admin.User").newInstance();

        User o1 = (User) Class.forName("com.xiayu.admin.User").getConstructor(String.class).newInstance("夏雨");

        System.out.println("");


    }


}
