package com.xiayu.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * topic 路由模式
 * *  匹配多个
 * #  满足#前面就性 等于是 **
 */

class DirectProvider_1{
    public static void main(String[] args) throws  Exception{
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
        //声明交换机 参数0 ，交换机名称， 参数1 交换机类型  路由模式
        channel.exchangeDeclare("logs_topic", "topic");

        String  routingKey = "user.name.sdf";
        //发布消息 参数0： 交换机。参数1 ：路由Key ，参数2 ：消息持久化。参数3 消息
        channel.basicPublish("logs_topic", routingKey, null, "hello+基于routing topic key ".getBytes());

        //关闭通道
        channel.close();
        //关闭主机
        connection.close();
    }

}



class DirectConsumer {
    public static void main(String[] args) throws  Exception{
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
        //声明交换机 参数0 ，交换机名称， 参数1 交换机类型
        channel.exchangeDeclare("logs_topic", "topic");

        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //基于route key 绑定队列和交换机  参数0 队列名称，参数1 交换机名称， 参数2 路由key
        channel.queueBind(queue,"logs_topic","user.*");

        //获取消费的消息
        channel.basicConsume(queue,true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1"+ new String(body));
            }
        });
    }

}

class DirectConsumer_2 {
    public static void main(String[] args) throws  Exception{
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
        //声明交换机 参数0 ，交换机名称， 参数1 交换机类型
        channel.exchangeDeclare("logs_topic", "topic");

        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //基于route key 绑定队列和交换机  参数0 队列名称，参数1 交换机名称， 参数2 路由key
        channel.queueBind(queue,"logs_topic","user.#");

        //获取消费的消息
        channel.basicConsume(queue,true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2"+ new String(body));
            }
        });
    }


}




