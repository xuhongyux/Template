package com.xiayu.oauth.domain;

import lombok.Data;

import java.sql.Date;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/26 19:48
 */
@Data
public class UserVo {

    private String id;
    private String user_name;
    private String pass_word;
    private Date create_time;
    private Date update_time;
    private Integer del_flag;
}
