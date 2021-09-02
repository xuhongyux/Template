package com.xiayu.feign.consumer.reflection;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-02-02-11:58
 */
public class UserPo {
    public static final  String  xiayu = "夏雨";
    private static final  String  xuhongyu = "许洪雨";
    private UserPo(){

    }

    public static void main(String[] args) {

    }

    @Override
    public  String toString(){
        return "hello ";
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
