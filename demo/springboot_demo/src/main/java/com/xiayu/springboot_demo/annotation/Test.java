package com.xiayu.springboot_demo.annotation;

import com.xiayu.springboot_demo.domain.UserPo;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-05-17:07
 */
public class Test {
    public static void main(String[] args) {
        test();

    }

    @AnnotationTest("value")
    private static  void test(){
        try {
            Class<UserPo> aClass = (Class<UserPo>) Class.forName("com.xiayu.springboot_demo.domain.UserPo");
            UserPo cast = aClass.newInstance();
            System.out.println(cast);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
