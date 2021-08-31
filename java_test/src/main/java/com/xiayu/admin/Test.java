package com.xiayu.admin;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-31-5:08 下午
 */
public class Test {
    public static void main(String[] args) {
        UserPo xiayu = new UserPo("xiayu", "12");
        System.out.println(xiayu.toString());

        UserPo xiayu1 = UserPo.builder().age("18").name("xiayu").build();
        System.out.println(xiayu1.toString());
    }
}