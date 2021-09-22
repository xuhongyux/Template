package com.xiayu.jvm.new_object;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-22-9:37 上午
 */
public class TestFather {
    public String test(){
        return "TestFather";
    }


    {
        System.out.println("TestFather 第一个静态代码块被调用！");
    }

    public TestFather(){
        System.out.println("TestFather 构造方法被调用");
    }


    {
        System.out.println("TestFather 第二个静态代码块被调用！");
    }

    public static String staticTest(String str){
        System.out.println("TestFather 静态代码被调用！");
        return "TestFather 静态方法"+str;
    }
}