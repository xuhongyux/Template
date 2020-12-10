package com.xiayu.singleton;

/**
 * @author xuhongyu
 * @describe  双检锁
 * @create 2020-11-20-14:55
 */
public class DoubleCheck {
    private static DoubleCheck instance;

    private DoubleCheck (){};

    public static DoubleCheck getDoubleCheck(){
        if(instance ==null){

            synchronized (DoubleCheck.class){
                if(instance ==null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
