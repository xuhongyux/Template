package com.xiayu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-17-2:37 下午
 */
@ApiModel
@Data
public class GetUserDto {

    @ApiModelProperty("名字")
    private String name;


    @ApiModelProperty("年龄")
    private Integer age;

}