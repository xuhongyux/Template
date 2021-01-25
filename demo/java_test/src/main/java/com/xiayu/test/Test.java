package com.xiayu.test;

import com.xiayu.admin.Root;
import com.xiayu.admin.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-12-18:48
 */
public class Test {

    public static void main(String[] args) throws  Exception{
        streamTest();

    }


    public static String streamTest(){


        ArrayList<User> objects = new ArrayList<>();
        User user = new User();
        user.setUserName("xiayu");

        User user1 = new User();
        user1.setUserName("夏雨");
        objects.add(user);
        objects.add(user1);

        List<User> collect = objects.stream().filter(op ->!(op.getUserName().equals("xiayu"))).collect(Collectors.toList());

        return collect.toString();


    }

    public static String transferLongToDates(String millSec)  {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        Date date = null;
        try {
            date = (Date) sdf.parse(millSec);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return formatStr2;
    }

    public static String transferLongToDate(String millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(Long.parseLong(millSec));
        return sdf.format(date);
    }

    public static String getOkDate(String date) {
        try {
            Date date1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH).parse(date);
            //格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
