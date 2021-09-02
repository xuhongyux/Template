package com.xiayu.feign.consumer.config.filter;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * @author xuhongyu
 * @create 2021-08-05 17:06
 */
public class JsonUtil {

    /**
     * 校验String 是否是Json
     *
     * @param jsonStr
     * @return
     */
    public static boolean validateJson(String jsonStr) {
        String trim = jsonStr.trim();
        if (trim.length() == 0) {
            return false;
        }
        try {
            JSONObject.parseObject(jsonStr);
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    /**
     * json 移除value值的前后空格 主要Json用的是alibaba
     *
     * @param
     * @return
     * @throws
     */
    public static JSONObject jsonStrTrim(JSONObject jsonObject) {
        JSONObject results = new JSONObject();

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
                    if (o instanceof JSONObject) {
                        JSONObject valueJSONObject = (JSONObject) o;
                        JSONObject jsonObjectSon = jsonStrTrim(valueJSONObject);
                        trimJsonArray.add(jsonObjectSon);
                    } else {
                        String oString = o.toString();
                        String oStringTrim = oString.trim();
                        trimJsonArray.add(oStringTrim);
                    }
                }
                results.put(key, trimJsonArray);
                // 非数组时
            } else {
                String value = entry.getValue().toString();
                if (validateJson(value)) {
                    JSONObject valueJson = JSONObject.parseObject(value);
                    if (valueJson == null) {
                        valueJson = new JSONObject();
                    }
                    JSONObject jsonTrim = jsonStrTrim(valueJson);
                    results.put(key, jsonTrim);
                } else {
                    String trimValue = value.trim();
                    results.put(key, trimValue);
                }
            }
        }
        return results;
    }
}
