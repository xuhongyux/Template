package com.xiayu.email.dto;

import com.xiayu.email.domain.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-18-2:20 下午
 */
@ApiModel
@Data
@ToString
public class RequestDto {

    private  String  content;

    private List<User> users;
}