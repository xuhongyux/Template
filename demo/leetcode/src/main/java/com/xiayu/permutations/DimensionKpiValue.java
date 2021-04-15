package com.xiayu.permutations;


import com.beust.jcommander.internal.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.Set;



@Data
@AllArgsConstructor
@ToString
public class DimensionKpiValue {

    /**
     *  List里放着所有的kPI的指标值，指标值必须str话
     *  如果List是null，说明不是末节点；
     *  如果List不为空且size>0，那么说明是末节点
     *  如果List的size = 0且不为空，说明是末节点但是kPI无值
     */
    Set<String> kPIs;

    String dimensionValue;

    String parentSequence;

    /**
     * 每一个dimension后面会有多个子dimensions
     * childrenDimensionValue中的dimensionValue为空的一定排在最后
     */
    Map<String, DimensionKpiValue> childrenDimensionValue;

    /**
     * 为了查询方便
     * key: 每个childrenDimensionValue的值
     * value: childrenDimensionValue在list中的index
     * 是、
     */
//    Map<String, Integer> childDimensionValueAndIndexMap;

    public DimensionKpiValue() {
        kPIs  = null;
        dimensionValue = null;
        childrenDimensionValue = Maps.newLinkedHashMap();
    }

}
