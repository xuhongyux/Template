package com.xiayu.gc;

import java.security.Provider;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-08-1:29 下午
 */
public class FinalizeTest {


    public static FinalizeTest SAVE_HOOK = null;


    //
    @Override
    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println("finalize method executed!");

         FinalizeTest.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeTest();

        //对象第一次成功拯救自己

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {

            System.out.println("yes, i am still alive :)");

        } else {

            System.out.println("no, i am dead :(");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {

            System.out.println("yes, i am still alive :)");

        } else {

            System.out.println("no, i am dead :(");
        }
    }
}