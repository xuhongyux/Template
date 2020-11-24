package com.xiayu.singleton;

/**
 * @author xuhongyu
 * @describe 懒汉式
 * @create 2020-11-20-14:42
 */
public class Lazy {
    private static Lazy instance;

    private Lazy(){

    }
    //public static Lazy getLazy(){
    public static synchronized Lazy getLazy(){
        if(instance ==null){
            instance = new Lazy();
        }
        return  instance;
    }
}
