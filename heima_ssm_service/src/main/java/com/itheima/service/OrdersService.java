package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;


public interface OrdersService {
    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAll(int page ,int size);

    /**
     * 根据id查询orders详情
     * @param id
     * @return
     */
    Orders findById(String id);

}
