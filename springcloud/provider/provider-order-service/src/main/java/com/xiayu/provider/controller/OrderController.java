package com.xiayu.provider.controller;

import com.xiayu.commons.entity.ResponseResult;
import com.xiayu.provider.api.OrderService;
import com.xiayu.provider.domain.OrderPo;
import com.xiayu.provider.params.OrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-16-11:28
 */
@Api(value = "账单",description ="账单" )
@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "创建账单",httpMethod = "POST")
    @PostMapping(value = "creatOrder")
    public ResponseResult<Void> creatOrder(@RequestBody OrderVo orderVo){
        orderService.createOrder(orderVo);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"创建账单",null);
    }
    @ApiOperation(value = "更新账单",httpMethod = "POST")
    @PostMapping(value = "updateOrder")
    public ResponseResult<Void> updateOrder(@RequestBody OrderVo orderVo){
        orderService.updaOrder(orderVo);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"更新账单",null);
    }

    @ApiOperation(value = "获取账单",httpMethod = "GET")
    @GetMapping(value = "getOrders")
    public ResponseResult<List<OrderPo>> getOrders(){
        List<OrderPo> order = orderService.getOrder();
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"更新账单",order);
    }



}
