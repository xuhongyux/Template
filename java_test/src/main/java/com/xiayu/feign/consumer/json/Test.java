package com.xiayu.feign.consumer.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beust.jcommander.internal.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-09-12:45 下午
 */
public class Test {

    public static void main(String[] args) {
        Role role = new Role();
        List<String> objects = Lists.newArrayList();
        objects.add("user");
        objects.add("root");
        role.setRoleName(objects);

        List<Role> newArrayList = Lists.newArrayList();
        newArrayList.add(role);


        Admin admin = new Admin();
        admin.setUserName("xiayu");
        admin.setRoles(newArrayList);

        String s = JSONObject.toJSONString(admin);
        System.out.println(s);
        System.out.println(admin);



        JSONObject jo2 = JSONObject.parseObject(s);

        JSONObject jsonTrim = Test.jsonStrTrim(jo2);
        String processBodyBytes = JSONObject.toJSONString(jsonTrim);
        Admin admin1 = JSONObject.parseObject(processBodyBytes, Admin.class);


   //     Admin admin2 = JSONObject.parseObject("{\"roles\":[{\"roleName\":[\"user\",\"root\"]}],\"userName\":\"xiayu\"}", Admin.class);
        System.out.println(admin1.toString());
    }
    /**
     * json 移除value值的前后空格 主要Json用的是alibaba
     *
     * @param
     * @return
     * @throws
     */
    public static JSONObject jsonStrTrim(JSONObject jsonObject) {
        // 开始遍历Json中当每个对象
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object valueObject = entry.getValue();
            // 当为数组时
            if (valueObject instanceof JSONArray) {
                JSONArray trimJsonArray = new JSONArray();

                JSONArray valueJsonArray = (JSONArray) valueObject;
                // 数组里面继续包含数组时，递归处理
                for (Object o : valueJsonArray) {
                    if(o instanceof JSONObject){
                        JSONObject valueJSONObject = (JSONObject) o;
                        JSONObject jsonObjectSon = jsonStrTrim(valueJSONObject);
                        trimJsonArray.add(jsonObjectSon);
                    } else {
                        String oString = o.toString();
                        String oStringTrim = oString.trim();
                        trimJsonArray.add(oStringTrim);
                    }
                }
                jsonObject.put(key,trimJsonArray);
                // 非数组时
            }else {
                String value = entry.getValue().toString();
                if (Test.validate(value)) {
                    JSONObject valueJson = JSONObject.parseObject(value);
                    JSONObject jsonTrim= jsonStrTrim(valueJson);
                    jsonObject.put(key,jsonTrim);
                } else {
                    String trimValue = value.trim();
                    jsonObject.put(key,trimValue);
                }
            }

        }
        return jsonObject;
    }



    public static boolean validate(String jsonStr) {
        JsonElement jsonElement;
        try {
            jsonElement = new JsonParser().parse(jsonStr);
        } catch (Exception e) {
            return false;
        }
        if (jsonElement == null) {
            return false;
        }
        if (!jsonElement.isJsonObject()) {
            return false;
        }
        return true;
    }
}