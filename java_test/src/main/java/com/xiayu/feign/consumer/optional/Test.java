package com.xiayu.feign.consumer.optional;

import com.xiayu.feign.consumer.admin.User;

import java.util.Optional;

/**
 * @author xuhongyu
 * @create 2021-03-29 17:13
 */
public class Test {
    @org.junit.Test
    public void testOptional(){
        User user = new User();
        Optional<User> empty = Optional.empty();
        boolean present = empty.isPresent();

    }
}
