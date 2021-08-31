package com.xiayu.test;

import com.xiayu.admin.User;

import java.util.Date;

/**
 * @author xuhongyu
 * @create 2021-07-10 17:02
 */
public class UserBo<T> extends Object {

    public static void main(String[] args) throws Exception {
        UserBo userBo = new UserBo<Date>();
        userBo.setContent(new Date());
        userBo.setName("");
        userBo.setPassword("");
        System.out.println();

        Object content = userBo.getContent();

    }

    private String name;

    private String password;

    private T content;


    public UserBo(String name, String password){
        this.name = name;
        this.password = password;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public  UserBo(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
