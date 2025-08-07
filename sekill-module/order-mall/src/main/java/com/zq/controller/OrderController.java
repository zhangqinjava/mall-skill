package com.zq.controller;

import com.mall.common.waapper.Result;
import com.mall.common.waapper.Wrapper;
import com.zq.bean.order.OrderParam;
import com.zq.bean.order.OrderRefundDto;
import com.zq.bean.order.OrderSaveDto;
import com.zq.bean.order.OrderUpdateDto;
import com.zq.service.OrderOperationImpl;
import com.zq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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

    /**
     * 用户下单
     * @param order
     * @return
     * @throws Exception
     */
    @GetMapping("/save")
    public Result save(@RequestParam @Valid OrderSaveDto order) throws Exception {
        return Wrapper.success(orderOperationImpl.operation(order));
    }

    /**
     * 查询订单
     * @param order
     * @return
     */
    @GetMapping("/query")
    public Result query( @RequestParam @Valid OrderParam order) {
        return Wrapper.success(orderService.findOrder(order));
    }

    /**
     * 更新订单信息
     * @param order
     * @return
     */
    @GetMapping("/update")
    public Result update(@RequestParam @Valid OrderUpdateDto order) {
        return Wrapper.wrap(orderService.updateOrder(order)=="1"?200:500,null);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam @NotEmpty(message="订单号不能为空") String orderId) {
        return Wrapper.wrap(orderService.deleteOrder(orderId)=="1"?200:500,null);
    }

    /**
     * 退款
     * @return
     */
    @GetMapping("/refund")
    public Result refund(@RequestParam @Valid OrderRefundDto orderRefundDto) {
        return Wrapper.wrap(200,null);
    }

}
