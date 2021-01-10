package com.xiayu.springboot_demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/10 14:35
 */
@Component
public class MqConsumerService {
    //hello 模式
    @RabbitListener(queuesToDeclare = @Queue(value = "hello"))
    public void receiveHello(String message) {
        System.out.println("hello 模式" + message);

    }

    //work 模式
    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receiveWork(String message) {
        System.out.println("work 模式1==" + message);
    }

    //work 模式
    @RabbitListener(queuesToDeclare = @Queue(value = "work"))
    public void receiveWork1(String message) {
        System.out.println("work 模式2==" + message);
    }

    //Fanout 模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Fanout",type = "fanout")
            )
    })
    public void receiveFanout(String message) {
        System.out.println("Fanout 模式1==" + message);
    }

    //Fanout 模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Fanout",type = "fanout")
            )
    })
    public void receiveFanout1(String message) {
        System.out.println("Fanout 模式2==" + message);
    }

    //Route-Directs模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Route_Directs",type = "direct"),
                    //路由key
                    key = {"error"}
            )
    })
    public void receiveRouteDirects(String message) {
        System.out.println("Route-Directs模式1==" + message);
    }
    //Route-Directs模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Route_Directs",type = "direct"),
                    //路由key
                    key = {"info"}
            )
    })
    public void receiveRouteDirects1(String message) {
        System.out.println("Route-Directs模式2==" + message);
    }

    //Route-Topic模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Route_Topic",type = "topic"),
                    //路由key
                    key = {"info.*.*"}
            )
    })
    public void receiveRouteTopics(String message) {
        System.out.println("Route-Topics模式1==" + message);
    }

    //Route-Topic模式
    @RabbitListener(bindings = {
            @QueueBinding(
                    //创建临时队列
                    value = @Queue,
                    //绑定交换机
                    exchange =  @Exchange(value = "xiayu_Route_Topics",type = "topic"),
                    //路由key
                    key = {"info.#"}
            )
    })
    // *  #
    public void receiveRouteTopics1(String message) {
        System.out.println("Route-Topic模式2==" + message);
    }



}
