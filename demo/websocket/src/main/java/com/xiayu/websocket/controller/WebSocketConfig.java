package com.xiayu.websocket.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/3/15 11:57
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 配置信息代理节点
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //配置一个代理节点 用不同的前缀来区分    ：   请求数据
        config.enableSimpleBroker("/queue","/topic","/user");
        //设置前端发送消息的前缀    ：    返回数据前缀
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 帮我们封装Websocket  URL的封装转换的一些列操作
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //addEndpoint（）设置服务端端口
        //withSockJS()处理浏览器兼容问题
        //setAllowedOrigins() 允许请求的类型
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }



}