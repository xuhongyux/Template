package com.example.springboot_test.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-07-02 11:09
 */
@RestController
@Api(value="/test1", tags="测试接口模块")
public class TestController {

    @ApiOperation("test")
    @GetMapping("/test")
    public String test()  {

        try {
            List<Double> objects1 = Lists.newArrayList();
            Date date = new Date();
            for (int i = 0; i < 10000; i++) {
                objects1.add(10000000000009999999999956756756756D);
            }
            ArrayList<Object> objects = Lists.newArrayList();

            Thread.sleep(10000);
            System.out.println("开始计算数据");
            double sum = objects1.parallelStream().mapToDouble(po -> po).sum();
            double sum1 = objects1.parallelStream().mapToDouble(po -> po).sum();
            double sum2 = objects1.parallelStream().mapToDouble(po -> po).sum();
            double sum3 = objects1.parallelStream().mapToDouble(po -> po).sum();
            double sum4 = objects1.parallelStream().mapToDouble(po -> po).sum();
            double sum5 = objects1.parallelStream().mapToDouble(po -> po).sum();
             objects1.parallelStream().forEach(
                     pos ->{
                         double sum6 = objects1.parallelStream().mapToDouble(po -> po).sum();
                         objects.add(sum6);
                     }
             );
            System.out.println("" + getInterval(date, new Date()));
            System.out.println(sum);
            System.out.println(sum1);
            System.out.println(sum2);
            System.out.println(sum3);
            System.out.println(sum4);
            System.out.println(sum5);
            System.out.println(sum5);

            objects1.clear();
        }  catch (Exception e) {

        }








        return "test成功";
    }
    public static float getInterval(Date begin, Date end) {
        return (float) (end.getTime() - begin.getTime()) / 1000;
    }



    public static void Enter() throws IOException {//停顿
        System.out.println("按回车继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

}
