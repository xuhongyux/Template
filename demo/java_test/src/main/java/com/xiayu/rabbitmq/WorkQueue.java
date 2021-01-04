package com.xiayu.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-31-11:53
 */
public class WorkQueue {


    public static void main(String[] args) throws  Exception{
        provider();

    }

    private  static void consumer1() throws Exception {
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
        channel.queueDeclare("hello", true, false, false, null);
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1: " + new String(body));
            }
        });
    }
    private  static void consumer2() throws Exception{
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
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);   //处理消息比较慢 一秒处理一个消息
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者2: "+new String(body));
            }
        });

    }


    private static void provider() throws  Exception{
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
        for (int i = 0; i < 10; i++) {
            //发布消息 参数0：交换机名称  参数1：队列名称 参数2：传递消息额外设置 参数3： 消息的具体内容
            channel.basicPublish("", "hello", null, (i+"====>:我是消息").getBytes());
        }

        //关闭通道
        channel.close();
        //关闭主机
        connection.close();
    }
}
