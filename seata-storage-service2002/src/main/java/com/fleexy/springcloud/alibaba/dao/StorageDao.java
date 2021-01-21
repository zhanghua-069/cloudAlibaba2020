package com.fleexy.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;

public interface StorageDao {

    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
