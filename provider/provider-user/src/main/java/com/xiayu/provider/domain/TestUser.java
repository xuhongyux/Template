package com.xiayu.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * Description: 
 * 
 * @Author xiayu
 * @Date 2020/9/29 15:29
 * @version v1.0.0
 */

/**
 * 测试用户表
 */
@ApiModel(value = "com-xiayu-provider-domain-TestUser")
@Data
public class TestUser implements Serializable {
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;

    private static final long serialVersionUID = 1L;
}