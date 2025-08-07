package com.zq.controller;

import com.mall.common.waapper.Result;
import com.mall.common.waapper.Wrapper;
import com.zq.bean.order.OrderParam;
import com.zq.service.OrderOperationImpl;
import com.zq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 下订单的操作
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 保存订单
     * @param order
     * @return
     */
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderOperationImpl orderOperationImpl;

    @GetMapping("/save")
    public Result save(OrderParam order) throws Exception {
        Map<Object, Object> operation = orderOperationImpl.operation(order);
        return Wrapper.success(operation);
    }
    @GetMapping("/query")
    public Result query(OrderParam order) {
        return Wrapper.success(orderService.findOrder(order));
    }
    @GetMapping("/update")
    public Result update(OrderParam order) {
        return Wrapper.wrap(orderService.updateOrder(order)=="1"?200:500,null);
    }
    @GetMapping("/delete")
    public Result delete(OrderParam order) {
        return Wrapper.wrap(orderService.deleteOrder(order)=="1"?200:500,null);
    }

}
