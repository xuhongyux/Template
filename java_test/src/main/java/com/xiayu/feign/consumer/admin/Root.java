package com.xiayu.feign.consumer.admin;

import lombok.Builder;
import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-13-14:41
 */
@Builder
@Data
public class Root extends  Psrson {
    private  String name;
}
