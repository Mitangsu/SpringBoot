package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Order;
import com.atguigu.admin.mapper.OrderMapper;
import com.atguigu.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Su
 * @create 2022-04-30 23:06
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    OrderMapper orderMapper;

    public Order getOrderById(Integer orderId){

        return orderMapper.getOrderById(orderId);
    }
}
