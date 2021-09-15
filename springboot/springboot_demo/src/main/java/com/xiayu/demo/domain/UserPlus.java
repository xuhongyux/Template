package com.xiayu.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-13-5:58 下午
 */
@Data
@TableName("user_plus")
public class UserPlus {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}