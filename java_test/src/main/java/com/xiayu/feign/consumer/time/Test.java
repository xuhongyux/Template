package com.xiayu.feign.consumer.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-03-21-16:59
 */
public class Test {

    public final static Integer SECONDS_IN_ADAY = 24*60*60;

    public static void main(String[] args) {
        //上周二
        Date date = beforeDate(9);
        //本周四
        Date date1 = beforeDate(3);
        double i = calculatetimeGapSecond(date, date1);
        System.out.println(i);

    }
    /**
     * 比较两个时间相差秒 移除
     * */
    public static double calculatetimeGapSecond(Date starDate, Date endDate) {
        double second = 0;
        double millisecond = endDate.getTime() - starDate.getTime();
        second = millisecond / (1000);
        //移除星期天
        int calLeaveDays = calLeaveDays(starDate, endDate);
        second  = second - calLeaveDays*SECONDS_IN_ADAY;
        return second;
    }

    public static int calLeaveDays(Date t1,Date t2){
        //初始化第一个日期
        Calendar cal1 = Calendar.getInstance();
        //初始化第二个日期，这里的天数可以随便的设置
        Calendar cal2 = Calendar.getInstance();
        // 对 calendar 设置为 date 所定的日期
        cal1.setTime(t1);
        cal2.setTime(t2);
        int holidays = 0;
        //确定一个 大日期
        if(cal1.compareTo(cal2) > 0){
            Calendar temp = cal1;
            cal1 = cal2;
            cal2 = temp;
        }
        while(cal1.compareTo(cal2)<=0){
            if(cal1.get(Calendar.DAY_OF_WEEK)==1||cal1.get(Calendar.DAY_OF_WEEK)==7){
                holidays++;
                //System.out.println("周末："+new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime()));
            }
            cal1.add(Calendar.DAY_OF_YEAR,1);
        }
        return holidays;
    }
    /**
     * 获得多少天前的时间
     */
    public static Date beforeDate(int lastDays) {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_YEAR);
        c.set(Calendar.DAY_OF_YEAR, day - lastDays);
        return c.getTime();
    }


}
