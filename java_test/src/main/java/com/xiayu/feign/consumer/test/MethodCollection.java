package com.xiayu.feign.consumer.test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-02-02-18:33
 */
public class MethodCollection {

    public static void main(String[] args) {
       StringBuilder a = null;
        String s = a.toString();
    }

    public static void test( Map<String, Set<String>> caseIdByPermutationName){
        caseIdByPermutationName.put("xuhongyu",Sets.newHashSet());
    }
}
