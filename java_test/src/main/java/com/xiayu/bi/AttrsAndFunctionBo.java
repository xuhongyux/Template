package com.xiayu.bi;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Stack;

@Data
@AllArgsConstructor
public class AttrsAndFunctionBo {

    /**
     * 函数栈
     */
    private List<Stack<CustomFunctionObjBo>> functionStack;

    /**
     * 属性集合
     */
    private List<AttrTypeBo> attrList;

    public AttrsAndFunctionBo(){

    }



}
