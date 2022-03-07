package com.xiayu.springboot_ignite.service;

import com.xiayu.springboot_ignite.dto.TestObject;

/**
 * @author xuhongyu
 * @create 2022-03-03 10:35 上午
 */
public interface TestService {

    TestObject save(TestObject testObject);

    TestObject findTestObjectById(long id);
}
