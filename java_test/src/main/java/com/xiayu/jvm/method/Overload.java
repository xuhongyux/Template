package com.xiayu.jvm.method;

import java.io.Serializable;

/**
 * @author xuhongyu
 * @describe
 * 重载方法匹配优先级
 * @create 2021-09-23-9:52 上午
 */
public class Overload {
    /**
     * 优先级 6
     * @param arg
     */
    public static void sayHello(Object arg) {

        System.out.println("hello Object");

    }

    /**
     * 优先级  2
     * @param arg
     */
//    public static void sayHello(int arg) {
//
//        System.out.println("hello int");
//
//    }


    /**
     * 优先级 3
     * @param arg
     */
//    public static void sayHello(long arg) {
//
//        System.out.println("hello long");
//
//    }

    /**
     * 优先级 4
     * @param arg
     */
//    public static void sayHello(Character arg) {
//
//        System.out.println("hello Character");
//
//    }

    /**
     * 优先级 1
     * @param arg
     */
//    public static void sayHello(char arg) {
//
//        System.out.println("hello char");
//
//    }

    /**
     * 优先级 7
     * @param arg
     */
    public static void sayHello(char... arg) {

        System.out.println("hello char ...");

    }


    /**
     * 优先级 5
     * @param arg
     */
//    public static void sayHello(Serializable arg) {
//
//        System.out.println("hello Serializable");
//
//    }

    public static void main(String[] args) {

        sayHello('a');

    }


}