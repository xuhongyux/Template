package com.xiayu.json;

import com.google.gson.Gson;
import com.xiayu.admin.User;
import com.xiayu.admin.UserPo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-10-13-4:48 下午
 */
public class GsonTest {

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();

        List<UserPo> convertContent = new ArrayList<>();
        UserPo user = new UserPo();
        user.setName("123");

        String age = user.getAge();

        convertContent.add(user);
        hashMap.put("data",convertContent);


        String s = new Gson().toJson(hashMap);
        System.out.println(s);
        // {"data":[{"age":"123"}]}
    }
}