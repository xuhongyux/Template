package com.xiayu.provider.api;

import com.xiayu.provider.domain.OrderPo;
import com.xiayu.provider.params.OrderVo;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-16-11:37
 */
public interface OrderService {

    List<OrderPo> getOrder();
    /**
     * 创建订单
     * @param orderVo
     */
    void createOrder(OrderVo orderVo);

    /**
     * 修改订单
     */
    void updaOrder(OrderVo orderVo);

    /**
     * 修改订单 - 用户Id
     * @param orderVo
     */
    void updaOrderByUserId(OrderVo orderVo);
}
