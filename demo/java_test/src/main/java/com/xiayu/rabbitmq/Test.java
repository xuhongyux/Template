package com.xiayu.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-31-10:58
 */
public class Test {
    public static void main(String[] args) throws  Exception{
        provider();
    }
    public static void provider() throws Exception{
        //创建链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机名称
        connectionFactory.setHost("47.93.246.173");
        connectionFactory.setPort(5672);
        //用户名和密码
        connectionFactory.setUsername("xiayu");
        connectionFactory.setPassword("xiayu");
        //虚拟主机
        connectionFactory.setVirtualHost("/xiayu");
        //构建链接
        Connection connection = connectionFactory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列 参数0： 队列名称 参数1: 是否持久化  参数2:是否独占队列 参数3:是否自动删除  参数4:其他属性
        channel.queueDeclare("hello",true,false,false,null);
        //发布消息 参数0：交换机名称  参数1：队列名称 参数2：传递消息额外设置 参数3： 消息的具体内容
        for (int i = 0; i < 10; i++) {
            //发布消息 参数0：交换机名称  参数1：队列名称 参数2：传递消息额外设置 参数3： 消息的具体内容
            channel.basicPublish("", "hello", null, (i+"====>:我是消息").getBytes());
        }
        System.out.println("消息推送完成");
        //关闭通道
        channel.close();
        //关闭主机
        connection.close();
    }
}
