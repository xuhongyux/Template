package com.example.springboot_http.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author xuhongyu
 * @create 2021-08-05 13:27
 */
@Data
public class UserDto {

    private  String userDtoFlag;


    private Long age;

    private String nickName;

    private Date creatDate;

    public UserDto(){
        this.creatDate = new Date();
    }
}
