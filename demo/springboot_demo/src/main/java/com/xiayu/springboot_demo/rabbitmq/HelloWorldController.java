package com.xiayu.springboot_demo.rabbitmq;

import com.xiayu.springboot_demo.domain.UserPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/10 14:27
 */
@RestController
@RequestMapping("rabbitMq/")
@Api(tags = "RabbitMQ消息队列")
public class HelloWorldController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation("Work模式")
    @GetMapping(value = "testWork/{message}" )
    public String testWork(@PathVariable String message){
        rabbitTemplate.convertAndSend("work",message);
        return "";
    }

    @ApiOperation("hello模式")
    @GetMapping(value = "testHello/{message}" )
    public String testHello(@PathVariable String message){
        rabbitTemplate.convertAndSend("hello",message);
        return "";
    }

    @ApiOperation("Fanout模式")
    @GetMapping(value = "testFanout/{message}" )
    public String testFanout(@PathVariable String message){
        rabbitTemplate.convertAndSend("xiayu_Fanout","",message);
        return "";
    }

    @ApiOperation("Route-Directs模式")
    @GetMapping(value = "testRoute/{routing}/{message}" )
    public String testRoute(@PathVariable String routing,@PathVariable String message){
        rabbitTemplate.convertAndSend("xiayu_Route_Directs",routing,message);
        return "";
    }
    @ApiOperation("Route-topics模式")
    @GetMapping(value = "testRouteTopics/{routing}/{message}" )
    public String testRouteTopics(@PathVariable String routing,@PathVariable String message){
        rabbitTemplate.convertAndSend("xiayu_Route_Topics",routing,message);
        return "";
    }




}
