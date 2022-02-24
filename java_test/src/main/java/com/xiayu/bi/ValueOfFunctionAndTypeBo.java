package com.xiayu.bi;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author quanhaoxing
 * @create 2021-05-10
 */
@Data
@AllArgsConstructor
public class ValueOfFunctionAndTypeBo {
    /**
     * value的值
     */
    String value;

    /**
     * 值的类型 (string or column)
     *
     */
    String type;


    /**
     * 执行顺序（从1开始）
     */
    Integer seq;


}
