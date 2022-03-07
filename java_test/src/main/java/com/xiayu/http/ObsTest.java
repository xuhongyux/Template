package com.xiayu.http;

import com.obs.services.model.PutObjectResult;

import java.io.File;

/**
 * @author xuhongyu
 * @create 2022-03-01 5:45 下午
 */
public class ObsTest {
    public static void main(String[] args) {
        ObsUtils obsUtils = new ObsUtils();
        File file = new File("/Users/xiayu/Pictures/壁纸/43vvmv.jpg");
        PutObjectResult xiayu = obsUtils.putLocalFile("xiayu", "1231312312.jpg", file);
        System.out.println();
    }
}
