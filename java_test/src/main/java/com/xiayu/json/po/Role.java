package com.xiayu.json.po;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-09-3:35 下午
 */

public class Role {
    List<String> roleName;

    String level;

    public Role(Object roleName, String level) {
        this.level = level;

        if (roleName instanceof String) {
            List<String> objects = new ArrayList<>();
            objects.add(roleName.toString());
            this.roleName = objects;
        }
        if (roleName instanceof List) {
            this.roleName = (List<String>) roleName;
        }

    }
}