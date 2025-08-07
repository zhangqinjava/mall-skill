package com.zq.service;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;
import com.zq.bean.order.OrderUpdateDto;

import java.util.List;

public interface OrderService {
    String saveOrder(Order order);
    String deleteOrder(String orderId);
    String updateOrder(OrderUpdateDto order);
    List<Order> findOrder(OrderParam orderId);

}
