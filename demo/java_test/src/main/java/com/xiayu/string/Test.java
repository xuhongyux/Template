package com.xiayu.string;



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
     * 判断第二个字符，和第一个字符的前半部分是否一致
     *
     * @param sourceString
     * @param startChar
     * @return
     */
    public static Boolean stringEqualStartChar() {
       StringBuilder a = new StringBuilder();
        a.append("许洪雨");
       String b = "雨";
        System.out.println(a.deleteCharAt(a.length() - b.length()-1).toString());
        return  false;
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
