package com.xiayu.feign.consumer.time;

import java.util.Date;

/**
 * @author xuhongyu
 * @create 2021-05-15 11:29
 */
public class TimeSerialization {

    public static void main(String[] args) {

        Date date = new Date();
        Long dateLong = date.getTime();
        System.out.println(dateLong.toString());
    }
}
