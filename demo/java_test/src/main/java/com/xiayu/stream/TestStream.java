package com.xiayu.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @create 2021-03-03-9:57 上午
 */
public class TestStream {
    public static void main(String[] args) {
        Map hashMap = new HashMap<String, UserPo>();
        hashMap.put("xiayu",new UserPo("xiayu","15"));
        hashMap.put("xuhongyu",new UserPo("xuhongyu","15"));

        Map hashMap1 = new HashMap<String, UserPo>();
        hashMap.put("huihui",new UserPo("huihui","15"));
        hashMap.put("xiaoming",new UserPo("xiaoming","15"));

        List<Map> list = new ArrayList<>();
        list.add(hashMap);
        list.add(hashMap1);


       // list.stream().filter(vo ->vo.containsKey("xiayu")).collect(Collectors.toCollection(map ->map));





    }
}