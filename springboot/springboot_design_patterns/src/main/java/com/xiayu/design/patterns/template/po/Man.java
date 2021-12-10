package com.xiayu.design.patterns.template.po;

import lombok.Data;

/**
 * @author xuhongyu
 * @create 2021-12-08 3:03 下午
 */
@Data
public class Man {

    public String name;

    public String getName(){
        return "man"+name;
    }
}
