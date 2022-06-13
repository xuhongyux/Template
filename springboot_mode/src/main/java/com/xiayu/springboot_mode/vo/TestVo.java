package com.xiayu.springboot_mode.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @create 2022-05-09 4:46 下午
 */
@Data
@ApiModel
public class TestVo {


    private List<List<String>> header;

    private Map<String,String> parameterMap;
}
