package com.xiayu.provider.mapper;

import com.xiayu.provider.domain.OrderPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
@describe
@author xuhongyu
@create 2020-12-16-11:23
*/
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderPo record);

    int insertSelective(OrderPo record);

    OrderPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderPo record);

    int updateByPrimaryKey(OrderPo record);

    List<OrderPo> selectAll();

    void updateByUserIdSelective(OrderPo orderPo);
}