package com.zq.service.impl;

import com.zq.bean.Order;
import com.zq.bean.OrderParam;
import com.zq.mapper.OrderMapper;
import com.zq.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Transactional(rollbackFor = Exception.class)   
    @Override
    public String saveOrder(OrderParam orderParam) {
        //封装order实例
        Order order=new Order();
        BeanUtils.copyProperties(orderParam,order);
        order.setOrderId(UUID.randomUUID().toString());
        //保存订单
        orderMapper.insert(order);
        //扣减库存
        return String.valueOf(orderMapper.insert(order););
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteOrder(OrderParam orderId) {
        return orderMapper.delete(orderId);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateOrder(OrderParam order) {
        return String.valueOf(orderMapper.update(order));
    }
    @Override
    public List<Order> findOrder(OrderParam orderId) {
        return Collections.emptyList();
    }
}
