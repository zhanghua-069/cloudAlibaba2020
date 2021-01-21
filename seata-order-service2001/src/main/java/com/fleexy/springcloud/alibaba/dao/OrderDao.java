package com.fleexy.springcloud.alibaba.dao;

import com.fleexy.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    //新建订单
    void create(Order order);

    //修改订单状态，从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
