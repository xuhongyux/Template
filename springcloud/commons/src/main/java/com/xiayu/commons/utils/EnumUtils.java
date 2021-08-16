package com.xiayu.commons.utils;

import java.util.Random;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/11/6 16:42
 */
public class EnumUtils {

    private static Random runnable = new Random(21) ;

    /**
     * 随机选择枚举类里的一个实例
     * @param ec
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> Enum random(Class<T> ec){
        return random(ec.getEnumConstants());

    }
    private static <T>  T random(T[] values) {
        return  values[runnable.nextInt(values.length)];
    }
}
