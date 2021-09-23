package com.xiayu.jvm.local_variables_table;

import org.junit.Test;

/**
 * @author xuhongyu
 * @describe
 *
 *  栈帧
 *
 *  测试时加上参数
 *  -verbose：gc
 * @create 2021-09-22-4:11 下午
 */
public class FrameTest {

    public static void main(String[] args) {
        FrameTest frameTest = new FrameTest();
        //frameTest.test();
        //frameTest.test_1();
        //frameTest.test_2();
        frameTest.test_3();
    }

    /**
     * 垃圾没有被回收
     * 因为在执行System.gc()时，
     *
     * 变量placeholder还处于作用域之内，虚拟机自然不敢回收掉placeholder的内存。
     */
    public void  test(){
        byte[] placeholder = new byte[64*1024*1024];
        System.gc();
    }


    /**
     * 加入了花括号之后，placeholder的作用域被限制在花括号以内，从代码逻辑上讲，在执行
     *
     * System.gc()的时候，placeholder已经不可能再被访问了，但执行这段程序，会发现运行结果如下，还是
     *
     * 有64M B的内存没有被回收掉，
     */
    public void test_1(){
        {

            byte[] placeholder = new byte[64 * 1024 * 1024];

        }
        System.gc();
    }


    /**
     * 和 test_1对比只是加了一行代码
     */
    public void test_2(){
        {

            byte[] placeholder = new byte[64 * 1024 * 1024];

        }
        int a = 0;
        System.gc();
    }


    /**
     * 外部的 只有基本类型才会初始化变量，包装类型并不会
     */
    private boolean external;

    /**
     * 局部变量必须要给予初始值
     * @return
     */
    public  Object test_3(){
        Boolean inside = null;

        System.out.println("external:"+external);
        // 若不初始化，编译会报错
        System.out.println("inside:"+ inside);
        return  null;
    }
}