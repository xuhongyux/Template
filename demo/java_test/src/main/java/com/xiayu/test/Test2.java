package com.xiayu.test;

import java.util.HashMap;

/**
 * @author xuhongyu
 * @create 2021-07-07 9:25
 */
public class Test2 {

    public static void main(String[] args) {
        String a = "中国人";
        String b = a;
        StringBuilder sb = new StringBuilder();
        String c = sb.append(a).append("1").toString();
        String d = "中国人"+"1";
        String e = "中国人1";
        String f = a + "1";
        String g = "值1";
        String h = "值2";
        String i = "中国人@1";
        String[] split = i.split("@");
        String[] split2 = i.split("@");
        HashMap<String, String> a1 = new HashMap<>();
        a1.put(a, a);

        e = "中国人2";

        a = "中国人2";
        HashMap<String, String> a2 = new HashMap<>();
        if (a1.containsKey(split[0])) {
            a2.put(a1.get(split[0]),a1.get(split[0]));
        }

        String x2 = "中国人".intern();
        String x3 = "中国人1".intern();
        String[] split3 = i.split("@");
        String x1 = split3[0].intern();

        System.out.println(x2==x1);
    }

}
