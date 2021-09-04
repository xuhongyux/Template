package com.xiayu.java_api.string;

/**
 * @author xuhongyu
 * @describe
 * 力扣 541.反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * @create 2020-11-26-17:21
 */
public class ReverseString {

    public static void main(String[] args) {

        System.out.println(ReverseString.reverseStr("abcde"));
    }

    public String Solution(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
                while (i < j) {
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
        return new String(a);
    }

    static  String  reverseStr(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length;

        while (i<j){
            char o = chars[i];
            chars[i] = chars[j-1];
            chars[j-1] = o;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
