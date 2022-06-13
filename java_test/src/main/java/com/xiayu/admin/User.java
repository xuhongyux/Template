package com.xiayu.admin;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-28-15:57
 */

public class User {
    private String userName = "xiayu";

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

}
