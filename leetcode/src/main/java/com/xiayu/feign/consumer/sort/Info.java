package com.xiayu.feign.consumer.sort;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author xuhongyu
 * @create 2021-05-13 14:33
 */

@Data
@ToString
public class Info {
    private String name;
    private int x;
    private int y;
    private int z;

    private Date data;


    public Info(String name, int x, int y, int z,Date data) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.data = data;

    }
}
