package com.xiayu.email.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-18-2:21 下午
 */
@ApiModel
@Data
public class User {

    private String userName;

    private  Long userAge;
}