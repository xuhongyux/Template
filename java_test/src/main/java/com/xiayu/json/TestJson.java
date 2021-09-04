package com.xiayu.json;

import com.alibaba.fastjson.JSONObject;
import com.xiayu.admin.User;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-25-6:25 下午
 */
public class TestJson {

    public static void main(String[] args) {
        User xiayu = new User("xiayu");

        String s = JSONObject.toJSONString(xiayu);

        System.out.println(s);

    }
}