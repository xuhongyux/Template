package com.example.springboot_test.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;


/**
 * @author xuhongyu
 * @describe 亿通报关消息推送接口
 * @create 2021-09-14-3:22 下午
 */
@Data
@ApiModel
public class EasipassCustomsPushDTO implements Serializable {

    private EasipassCustomsPushDataDTO data;
    private String info;
    private String flag;
}