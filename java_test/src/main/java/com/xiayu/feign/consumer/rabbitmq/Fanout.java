package com.xiayu.feign.consumer.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * Description:
 * 广播模型
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/4 20:26
 */
public class Fanout {

    public static void main(String[] args) throws Exception {
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
        channel.exchangeDeclare("logs", "fanout");

        //发布消息 参数0： 交换机。参数1 ：路由Key ，参数2 ：消息持久化。参数3 消息
        channel.basicPublish("logs", "", null, "hello".getBytes());

        //关闭通道
        channel.close();
        //关闭主机
        connection.close();
    }


}

class Consumer1 {
    public static void main(String[] args) throws  Exception {
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

        Channel channel = connection.createChannel();
        //绑定交换机  类型和生产者一致
        channel.exchangeDeclare("logs", "fanout");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //将临时队列绑定exchange   参数0： 临时队列名称。 参数1 ： 交换机名称， 参数2：路由Key
        channel.queueBind(queue, "logs", "");
        //处理消息 参数0：临时队列名称 。参数1： 是否自动确认， 参数2 DefaultConsumer
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1: " + new String(body));
            }
        });

    }

}

class Consumer2 {
    public static void main(String[] args) throws Exception {
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
        Channel channel = connection.createChannel();
        //绑定交换机  类型和生产者一致
        channel.exchangeDeclare("logs", "fanout");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //将临时队列绑定exchange   参数0： 临时队列名称。 参数1 ： 交换机名称， 参数2：路由Key
        channel.queueBind(queue, "logs", "");
        //处理消息 参数0：临时队列名称 。参数1： 是否自动确认， 参数2 DefaultConsumer
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2: " + new String(body));
            }
        });

    }

}
