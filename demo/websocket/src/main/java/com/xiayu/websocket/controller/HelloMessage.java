package com.xiayu.websocket.controller;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/3/15 11:56
 */
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
