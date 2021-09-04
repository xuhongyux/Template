package com.xiayu.java_api.string;



/**
 * @author xuhongyu
 * @create 2021-06-29 15:31
 */
public class Test {
    public static void main(String[] args) {
        String a = "许洪雨";
        String b = "许";
       // stringEqualStartChar();
        stringTrim("xu ");


        System.out.println(stringTrim("xu"));
        System.out.println(stringTrim(" xu "));
        System.out.println(stringTrim("   xu "));

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
