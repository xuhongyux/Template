package com.xiayu.time;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-10-20-9:54 上午
 */
public class TimeForamt {
    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        LocalDateTime planArrivalDate = LocalDateTime.parse("2020-11-11 10:10:10", dateFormat);
        System.out.println(planArrivalDate);
    }

    /**
     *  hutool工具类识别时间
     */
    @Test
    public  void hutoolTimeFormat(){
        String dateStr = "2020-11-11 10:10:10";
        String dateStr1 = "2020/11/11";
        DateTime parse = DateUtil.parse(dateStr);
        DateTime parse1 = DateUtil.parse(dateStr1);
        System.out.println(parse);
        System.out.println(parse1);

    }
}