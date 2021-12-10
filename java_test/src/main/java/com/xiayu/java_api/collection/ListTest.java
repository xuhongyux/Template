package com.xiayu.java_api.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-12-08 3:57 下午
 */
public class ListTest {

    @Test
    public void synchronizedList(){
        List<String> objects = new ArrayList<>();

        objects = Collections.synchronizedList(objects);

    }
}
