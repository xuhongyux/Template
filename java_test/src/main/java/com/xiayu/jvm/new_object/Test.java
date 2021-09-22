package com.xiayu.jvm.new_object;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-18-5:28 下午
 */
public class Test extends TestFather {

    @org.junit.Test
    public void main() {
        UserPo userPo = new UserPo();
        String test = super.test();
        System.out.println();
    }
}