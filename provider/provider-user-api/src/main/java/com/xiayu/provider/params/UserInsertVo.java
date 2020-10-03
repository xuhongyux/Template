package com.xiayu.provider.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/3 12:08
 */
@Data
public class UserInsertVo {
    private String name;
    private String password;
    private String tel;

    @ApiModelProperty(value="用户类型，0 超级管理员，1 管理员 ，2 操作人员")
    private Integer type;
}
