package com.zq.service;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;

import java.util.List;

public interface OrderService {
    String saveOrder(OrderParam order);
    String deleteOrder(OrderParam orderId);
    String updateOrder(OrderParam order);
    List<Order> findOrder(OrderParam orderId);

}
