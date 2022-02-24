package com.xiayu.bi;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomFunctionObjBo {

    /**
     * 函数名称
     */
    private CalculatingSignsEnum function;

    /**
     * 方法对应值
     */
    private List<ValueOfFunctionAndTypeBo> values;

    /**
     * 下级
     */
    private List<CustomFunctionObjBo> child;

    private boolean haveIdsName;

    /**
     * 执行顺序（从1开始）
     */
    private Integer seq;

    /**
     * 用户自定义的属性名
     */
    private String asOfHeader;

    public CustomFunctionObjBo() {
        this.child = new ArrayList<>();
        this.haveIdsName = false;
    }

}
