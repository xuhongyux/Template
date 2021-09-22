package com.xiayu.jvm.new_object;

import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-18-5:28 下午
 */
@Data
public class UserPo {

    public String userName;
    {
        System.out.println("第一个静态代码块被调用！");
    }

    public UserPo(){
        System.out.println("构造方法被调用");
    }


    {
        System.out.println("第二个静态代码块被调用！");
    }

    public static String staticTest(String str){
        System.out.println("静态代码被调用！");
        return "静态方法"+str;
    }
}