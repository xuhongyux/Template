package com.xiayu.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xuhongyu
 * @create 2021-06-29 15:31
 */
public class Test {
    public static void main(String[] args) {
        String a = "许洪雨";
        String b = "许";
        Boolean aBoolean = stringEqualStartChar(a, b);
        System.out.println(aBoolean);
    }
    /**
     * 判断第二个字符，和第一个字符的前半部分是否一致
     *
     * @param sourceString
     * @param startChar
     * @return
     */
    public static Boolean stringEqualStartChar(String sourceString, String startChar) {
        if ((!StringUtils.isEmpty(sourceString)) && (!StringUtils.isEmpty(startChar))) {
            int length = startChar.length();
            String substring = sourceString.substring(0, length);
            return  substring.equals(startChar);
        }
        return  false;
    }
}
