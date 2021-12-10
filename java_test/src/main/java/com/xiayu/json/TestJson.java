package com.xiayu.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiayu.admin.User;
import com.xiayu.json.po.Admin;
import com.xiayu.json.po.Role;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-25-6:25 下午
 */
public class TestJson {

    public static void main(String[] args) {


    }

    /**
     * 两层嵌套
     */
    @Test
    public void ObjectToJson(){
        Admin admin = new Admin();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("roleName","1"));
        admin.setRoles(roles);

        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("key","value");
        admin.setObj(objectObjectHashMap);

        Object o = JSON.toJSON(admin);

        String s = JSON.toJSONString(admin);
        System.out.println(o);
        System.out.println(s);


    }
}