package com.zq.service;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;

public interface OrderPayService {
    String pay(Order orderParam);

}
