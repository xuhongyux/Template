package com.xiayu.websocket.admin;

import java.security.Principal;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/3/16 12:36
 */
public final class User implements Principal {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
