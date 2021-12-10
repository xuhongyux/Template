package com.xiayu.design.patterns.template.po;

import lombok.Data;

/**
 * @author xuhongyu
 * @create 2021-12-08 3:02 下午
 */
@Data
public class Father extends  Man {


    public String name;

    @Override
    public String getName() {
        return "Father"+ name;
    }
}
