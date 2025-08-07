package com.zq.service.impl;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;
import com.zq.bean.order.OrderUpdateDto;
import com.zq.mapper.OrderMapper;
import com.zq.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Transactional(rollbackFor = Exception.class)   
    @Override
    public String saveOrder(Order order) {
        //保存订单
        orderMapper.insert(order);
        //扣减库存
        return String.valueOf(orderMapper.insert(order));
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String deleteOrder(String orderId) {
        return String.valueOf(orderMapper.delete(orderId));
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateOrder(OrderUpdateDto order) {
        return String.valueOf(orderMapper.update(order));
    }
    @Override
    public List<Order> findOrder(OrderParam orderId) {
        List<Order> order = orderMapper.findOrder(orderId);
        return order;
    }
}
