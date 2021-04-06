package com.xiayu.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        String s = hashMap.get("");
        System.out.println(s);
    }
}
