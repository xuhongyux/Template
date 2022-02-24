package com.xiayu.java_api.string;

/**
 * @author xuhongyu
 * @create 2022-01-28 10:20 上午
 */
public class ReplaceTest {

    public static void main(String[] args) {
        String a = "科目编码 = SPLIT(current.split == 1 ,'100213',current.split ==2 , '112202')";
        String replace = a.replace("current123", "宁波");
        System.out.println(replace);

    }
}
