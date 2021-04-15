package com.xiayu.utils;

/**
 * @author xuhongyu
 * @create 2021-04-09 20:07
 */
public class TestUtils {
    public static void main(String[] args) {
        String a = "xiayu";
        String b = "xiayuxuxu";
        String s = MapperUtils.stringReplaceStartChar(b, a);
        System.out.println(s);
    }
}
