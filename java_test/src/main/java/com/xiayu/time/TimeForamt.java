package com.xiayu.time;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static java.time.OffsetDateTime.now;

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
        long l = parse.toInstant().toEpochMilli();
        System.out.println(l);
        System.out.println(parse);
        System.out.println(parse1);

    }


    @Test
    public void dateTimeToLong(){
        LocalDateTime now = LocalDateTime.now();
        long l = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
    }

    @Test
    public void longToDateTime(){
        Long longL = 1635484372418L;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(longL),ZoneOffset.of("+8"));
        System.out.println(localDateTime.toString());
    }

}