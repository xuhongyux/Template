package com.xiayu.websocket.controller;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/3/17 13:12
 */

public class Response {
    private String  name ;
    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
