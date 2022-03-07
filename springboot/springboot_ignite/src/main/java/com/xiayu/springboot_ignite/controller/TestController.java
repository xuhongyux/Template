package com.xiayu.springboot_ignite.controller;

import com.xiayu.springboot_ignite.dto.TestObject;
import com.xiayu.springboot_ignite.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2022-03-03 10:37 上午
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public TestObject savePerson(@RequestParam(value = "id") long id, @RequestParam(value = "name") String name) {

        return testService.save(new TestObject(id, name));
    }

    @RequestMapping("/find")
    public TestObject findByCode(@RequestParam(value = "id") long id) {

        return testService.findTestObjectById(id);
    }
}
