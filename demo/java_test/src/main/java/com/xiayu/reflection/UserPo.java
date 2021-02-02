package com.xiayu.reflection;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-02-02-11:58
 */
public class UserPo {

    private UserPo(){

    }

    private UserPo(String userName){
        this.userName = userName;
    }

    public UserPo(String userName ,String age){
        this.userName = userName;
        this.age = age;
    }

    private String userName;

    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
