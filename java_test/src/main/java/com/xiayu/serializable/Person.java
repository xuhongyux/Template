package com.xiayu.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-01-10:16 上午
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 6730932214694319012L;

    public Long id;

    public String name;

    public static int staticVar = 5;
}