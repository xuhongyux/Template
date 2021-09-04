package com.xiayu.collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xuhongyu
 * @create 2021-03-26 9:35
 */
public class MapTest {

    /**
     * 校验Map 取空值取来的是什么
     * 为 null
     */
    @Test
    public void checkMapNull(){
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("123","123");

        hashMap.remove("123");
        System.out.println();
    }


    public static <k, v> List<Map<k, v>> mapChunk(Map<k, v> chunkMap, int chunkNum) {
        if (chunkMap == null || chunkNum <= 0) {
            List<Map<k, v>> list = new ArrayList<>();
            list.add(chunkMap);
            return list;
        }
        Set<k> keySet = chunkMap.keySet();
        Iterator<k> iterator = keySet.iterator();
        int i = 1;
        List<Map<k, v>> total = new ArrayList<>();
        Map<k, v> tem = new HashMap<>();
        while (iterator.hasNext()) {
            k next = iterator.next();
            tem.put(next, chunkMap.get(next));
            if (i == chunkNum) {
                total.add(tem);
                tem = new HashMap<>();
                i = 0;
            }
            i++;
        }

        return total;
    }


}
