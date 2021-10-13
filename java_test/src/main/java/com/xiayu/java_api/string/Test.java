package com.xiayu.java_api.string;



/**
 * @author xuhongyu
 * @create 2021-06-29 15:31
 */
public class Test {
    public static void main(String[] args) {
        String a = "许洪雨";
        String b = "许";
        String s = subStrByStrAndLen(a, 3);
        System.out.println(s);

    }

    /**
     * 截取指定长度的字符串
     *
     * @param str 原字符串
     * @param len 长度
     * @return 如果str为null，则返回null；如果str长度小于len，则返回str；如果str的长度大于len，则返回截取后的字符串
     */
    public static String subStrByStrAndLen(String str, int len) {
        return null != str ? str.substring(0, str.length() > len ? len : str.length()) : null;
    }

    /**
     * String format
     *
     * format(String format, Object… args) 新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。
     * format(Locale locale, String format, Object… args) 使用指定的语言环境，制定字符串格式和参数生成格式化的字符串。
     */
    @org.junit.Test
    public void formatTest(){
        String  str = "name = %s;";
        String xiayu = String.format( str, "xiayu");
        System.out.println(xiayu);

    }
    /**
     * 移除String前后空格
     * @return
     */
    public static String stringTrim(String str){
        String trim = str.trim();
        return trim;
    }

}