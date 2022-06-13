package com.xiayu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2022-03-30 3:24 下午
 */
public class Test {

    @org.junit.Test
    public void addInt() {
        List<Integer> bases = new ArrayList<>();
        bases.add(2);
        bases.add(4);
        bases.add(8);
        bases.add(16);
        bases.add(32);
        bases.add(64);

        int sum = 18+32;
        List<Integer> results = new ArrayList<>();

        for (Integer base : bases) {
            if (base == (sum & base)) {
                results.add(base);
            }
        }
        System.out.println(results);


    }
}
