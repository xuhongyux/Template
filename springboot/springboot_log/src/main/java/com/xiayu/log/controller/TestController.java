package com.xiayu.log.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-28-11:50
 */
@RestController
public class TestController {
    public final Logger logger= LoggerFactory.getLogger(getClass());


    @GetMapping(value = "/{userName}")
    public String test(@PathVariable String userName){
        logger.error(userName);
        return null;
    }
}
