package com.zq.mapper;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderMapper {
    int delete(OrderParam order);
    int update(OrderParam order);
    List<Order> findOrder(OrderParam orderId);
    int insert(Order order);
}
