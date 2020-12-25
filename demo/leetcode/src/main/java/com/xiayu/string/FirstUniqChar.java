package com.xiayu.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author xuhongyu
 * @describe 387. 字符串中的第一个唯一字符
 * 反馈
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * @create 2020-12-23-15:23
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        int adfda = test_4("adfda");
        System.out.println(adfda);
    }

    private static void test(String str) {
        char[] chars = str.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();

        int size = 0;
        for (char aChar : chars) {
            size = hashSet.size();
            hashSet.add(aChar);
            if (hashSet.size() == size) {
                System.out.println(aChar);
                break;
            }
        }

    }

    private static int test_1(String str) {
        int count[] = new int[26];
        char[] chars = str.toCharArray();
        //先统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            count[chars[i] - 'a']++;
        }

        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < str.length(); i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }

        }
        return -1;

    }

    public static int test_4(String s) {
        for (int i = 0; i < s.length(); i++){
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
            {
                return i;
            }

        }
        return -1;
    }
}
