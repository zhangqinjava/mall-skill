package com.zq.controller;

import com.mall.common.waapper.Result;
import com.mall.common.waapper.Wrapper;
import com.zq.bean.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/save")
    public Result save(Order order) {
        return Wrapper.success("");
    }
    @GetMapping("/query")
    public Result query(Order order) {
        return Wrapper.success("");
    }
    @GetMapping("/update")
    public Result update(Order order) {
        return Wrapper.success("");
    }
    @GetMapping("/delete")
    public Result delete(Order order) {
        return Wrapper.success("");
    }

}
