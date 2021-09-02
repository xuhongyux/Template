package com.xiayu.feign.consumer.admin;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-28-15:57
 */

public class User {
    private String userName;

    private List<Root> rootList;

    public User(String userName){
        this.userName = userName;
    }

    public User(){
    }



    @Override
    public  String toString(){
        return "sfasdfas";
    }

    public static void main(String[] args) {
        User xiuyuy = new User("xiuyuy");
        System.out.println(xiuyuy.toString());
    }
}
