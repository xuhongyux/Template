package com.xiayu.Operation;

import java.math.BigDecimal;

/**
 * @author xuhongyu
 * @create 2022-01-11 4:37 下午
 */
public class Test {
    public static void main(String[] args) {
        String str1 = "83143.12";
        String str = "7482.88";
        BigDecimal bigDecimal1 = new BigDecimal(str1);
        BigDecimal bigDecimal = new BigDecimal(str);
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal);
        System.out.println(subtract.toString());
    }
}
