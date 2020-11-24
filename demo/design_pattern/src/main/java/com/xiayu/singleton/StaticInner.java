package com.xiayu.singleton;

/**
 * @author xuhongyu
 * @describe 静态内部类
 * @create 2020-11-20-15:07
 */
public class StaticInner {
    private static class Singleon{
        private static final StaticInner instance = new StaticInner();
    }
    private StaticInner(){
    }

    public static StaticInner getStaticInner(){
        return Singleon.instance;
    }
}
