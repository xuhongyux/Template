package com.xiayu.java_api.enums;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhongyu
 * 港区映射
 * @create 2021-12-07 2:11 下午
 */
public enum DictionaryMapperEnums {
    /**
     * 外高桥
     */
    A001("外一", "外高桥一期", typeEnums.PORT_DISTRICT.name()),
    A002("外二", "外高桥二期", typeEnums.PORT_DISTRICT.name()),
    A003("外四", "外高桥四期", typeEnums.PORT_DISTRICT.name()),
    A004("外五", "外高桥五期", typeEnums.PORT_DISTRICT.name()),
    A005("洋一", "洋山一期", typeEnums.PORT_DISTRICT.name()),
    A006("洋二", "洋山二期", typeEnums.PORT_DISTRICT.name()),
    A007("洋三", "洋山三期", typeEnums.PORT_DISTRICT.name()),
    A008("洋四", "洋山四期", typeEnums.PORT_DISTRICT.name()),
    ;

    /**
     * 映射key
     */
    private String key;

    /**
     * 映射 value
     */
    private String value;

    /**
     * 映射类型
     */
    private String type;

    DictionaryMapperEnums(String key, String value, String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public enum typeEnums {
        /**
         * 港区
         */
        PORT_DISTRICT
    }

    /**
     * 获取映射结果
     * @param key
     * @param type
     * @return
     */
    public static String getMapperValue(String key, String type) {
        List<String> collect = Arrays.stream(values()).filter(en -> en.key.equals(key) && en.type.equals(type)).map(en -> en.value).collect(Collectors.toList());
        if(isEmpty(collect)){
            return key;
        }
        return collect.get(0);
    }

    public static void main(String[] args) {
        String a = getMapperValue("外四", typeEnums.PORT_DISTRICT.name());
        System.out.println(a);
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }
}
