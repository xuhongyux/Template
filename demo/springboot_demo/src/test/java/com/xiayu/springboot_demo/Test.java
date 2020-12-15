package com.xiayu.springboot_demo;

import com.xiayu.springboot_demo.utils.ThreadPoolUtil;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-14-14:31
 */
public class Test {
        public static void main(String[] args) {
            char [] cha = new char[1024];
            System.out.println(cha);
            new ThreadPoolUtil();

        }

}
