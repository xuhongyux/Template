package com.xiayu.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 排序
 *
 * @author xuhongyu
 * @create 2021-05-13 14:32
 */
public class Test {
    public static void main(String[] args) {
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE,1);
        Date date1=calendar.getTime();
        calendar.add(Calendar.DATE,32);
        Date date2=calendar.getTime();
        calendar.add(Calendar.DATE,7);
        Date date3=calendar.getTime();
        calendar.add(Calendar.DATE,1);
        Date date4=calendar.getTime();
        calendar.add(Calendar.DATE,-101);
        Date date5=calendar.getTime();

        Info info1 = new Info("1小木", 5, 4, 4,date1);
        Info info2 = new Info("2小望", 5, 4, 2,date2);
        Info info3 = new Info("3小明", 5, 6, 1,date3);
        Info info4 = new Info("4小李", 2, 1, 1,date4);
        Info info5 = new Info("5小张", 1, 1, 1,date5);
        Info info6 = new Info("6小san", 2, 5, 1,date);


        List<Info> infoList = new ArrayList();
        infoList.add(info1);
        infoList.add(info2);
        infoList.add(info3);
        infoList.add(info4);
        infoList.add(info5);
        infoList.add(info6);


        // 升序
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 > 0 ? -1 : 1;
            }
        };


        Comparator<Info> comparing = Comparator
                .comparing(Info::getX, Comparator.naturalOrder());


        // 默认是降序，Comparator.reverseOrder()
        List<Info> sort = infoList.stream().sorted(Comparator
                .comparing(Info::getX, Comparator.naturalOrder())
                .thenComparing(Info::getX, Comparator.naturalOrder())
                .thenComparing(Info::getY, Comparator.naturalOrder())
                .thenComparing(Info::getZ, Comparator.naturalOrder())

        ).collect(Collectors.toList());
        for (Info info : sort) {
            System.out.println(info.toString());
        }

    }


}
