package com.zq.service;

import com.zq.bean.Order;
import com.zq.bean.OrderParam;

import java.util.List;

public interface OrderService {
    String saveOrder(OrderParam order);
    int deleteOrder(OrderParam orderId);
    String updateOrder(OrderParam order);
    List<Order> findOrder(OrderParam orderId);

}
