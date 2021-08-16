package com.xiayu.provider.service;

import com.xiayu.commons.utils.BeanUtil;
import com.xiayu.commons.utils.SnowFlakeUtil;
import com.xiayu.provider.mapper.OrderMapper;
import com.xiayu.provider.api.OrderService;
import com.xiayu.provider.domain.OrderPo;
import com.xiayu.provider.params.OrderVo;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-16-11:35
 */
@Service(version = "1.0.0", timeout = 30000)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    @Override
    public List<OrderPo> getOrder() {
        List<OrderPo> orderPos = orderMapper.selectAll();
        return orderPos;
    }

    @Override
    public void createOrder(OrderVo orderVo) {
        Date date = new Date();
        OrderPo orderPo = new OrderPo();
        BeanUtil.copyPropertiesIgnoreNull(orderVo,orderPo);
        orderPo.setId(String.valueOf(snowFlakeUtil.nextId()));
        orderPo.setLastTime(date);
        orderPo.setCreateTime(date);
        orderPo.setUpdateTime(date);
        orderPo.setDelFlag(0);
        orderMapper.insert(orderPo);
    }

    @Override
    public void updaOrder(OrderVo orderVo) {
        Date date = new Date();
        OrderPo orderPo = new OrderPo();
        BeanUtil.copyPropertiesIgnoreNull(orderVo,orderPo);
        orderPo.setUpdateTime(date);
        orderMapper.updateByPrimaryKeySelective(orderPo);
    }

    @Override
    public void updaOrderByUserId(OrderVo orderVo) {
        Date date = new Date();
        OrderPo orderPo = new OrderPo();
        BeanUtil.copyPropertiesIgnoreNull(orderVo,orderPo);
        orderPo.setUpdateTime(date);
        orderMapper.updateByUserIdSelective(orderPo);
    }
}
