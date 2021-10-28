package com.xiayu.rabbitmq;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.xiayu.http.bo.WharfCtnTraceDTO;
import com.xiayu.rabbitmq.bo.CtnTraceNode;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-10-26-9:22 上午
 */
public class SpringTest {

    private String MDM_WHARF_CTN_TRACE_EXCHANGE = "MDM_WHARF_CTN_TRACE_EXCHANGE";

    @Test
    public void sendMq(){
        RabbitTemplate rabbitTemplate=  new RabbitTemplate();


        WharfCtnTraceDTO wharfCtnTraceDTO = new WharfCtnTraceDTO();

        wharfCtnTraceDTO.setTraceNodeCode(CtnTraceNode.CONTAINER_LOAD.toString());
        rabbitTemplate.convertAndSend(MDM_WHARF_CTN_TRACE_EXCHANGE, StrUtil.EMPTY, JSON.toJSONString(wharfCtnTraceDTO));



    }



}