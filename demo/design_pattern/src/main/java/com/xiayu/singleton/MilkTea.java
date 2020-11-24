package com.xiayu.singleton;

import lombok.NonNull;

/**
 * @author xuhongyu
 * @describe 原型模式
 * @create 2020-11-20-15:27
 */
public class MilkTea implements Cloneable {
    public String type;
    public boolean ice;

    @NonNull
    @Override
    protected MilkTea clone() throws CloneNotSupportedException {
        return (MilkTea) super.clone();
    }
}
