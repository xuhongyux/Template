package com.example.springboot_http.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONException;

import java.util.Map;
import java.util.Set;

/**
 * @author xuhongyu
 * @create 2021-08-05 17:06
 */
public class JsonUtil {

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

    /**
     * json 移除value值的前后空格 主要Json用的是alibaba
     * @param arr
     * @return
     * @throws JSONException
     */
    public  static JSONArray jsonStrTrim(JSONArray arr)   {
        if (arr != null && arr.size() > 0) {
            for (int i = 0; i < arr.size(); i++) {
                //取出 jsonObject 中的字段的值的空格
                Object o = arr.get(i);
                JSONObject obj = (JSONObject) arr.get(i);
                Set<Map.Entry<String, Object>> entries = obj.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String value = entry.getValue().toString();
                    String key = entry.getKey();
                    try {
                        if (value == null) {
                            continue;
                        } else if ("".equals(value.trim())) {
                            continue;
                        } else {
                            obj.put(key, value.trim());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                arr.set(i, obj);
            }
        }
        return arr;
    }
}
