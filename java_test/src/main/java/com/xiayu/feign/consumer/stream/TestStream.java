package com.xiayu.feign.consumer.stream;

import com.xiayu.feign.consumer.admin.UserPo;

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

        Map hashMap1 = new HashMap<String, Object>();
        hashMap1.put("huihui",1);
        hashMap1.put("xiaoming",2);
        hashMap.put("xiaoming",3);

        List<Map> list = new ArrayList<>();
        list.add(hashMap);
        list.add(hashMap1);

        HashMap<Object, Object> hashMap2 = new HashMap<>();


        for(Map<String,Object> map : list){
            hashMap2.put(map.get("xiaoming"),map);
        }
        System.out.println(hashMap2);
        // list.stream().filter(vo ->vo.containsKey("xiayu")).collect(Collectors.toCollection(map ->map));





    }
}