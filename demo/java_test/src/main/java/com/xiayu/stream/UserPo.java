package com.xiayu.stream;

import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-03-03-9:58 上午
 */
@Data
public class UserPo {

    public UserPo(String name,String age){
        this.name = name;
        this.age = age;
    }

    private String name;

    private String age;

    private String sex;
}