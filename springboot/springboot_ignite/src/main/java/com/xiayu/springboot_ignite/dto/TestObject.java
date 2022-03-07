package com.xiayu.springboot_ignite.dto;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @author xuhongyu
 * @create 2022-03-03 10:34 上午
 */
public class TestObject {

    @QuerySqlField(index = true)
    long id;
    String name;

    public TestObject(long id, String name) {

        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
