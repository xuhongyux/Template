package com.xiayu.feign.consumer.utils;

import java.math.BigDecimal;

/**
 * @author xuhongyu
 * @create 2021-04-09 20:07
 */
public class TestUtils {
    public static void main(String[] args) {
        double v = calculateOfPercentage(4, 5, 6);
        System.out.println(v);
    }

    public static double calculateOfPercentage(double molecule, int denominator, int scale) {
        if (molecule == 0 || denominator == 0) {
            return 0.00D;
        } else {
            return new BigDecimal(molecule / denominator).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }
}
