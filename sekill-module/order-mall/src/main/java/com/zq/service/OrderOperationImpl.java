package com.zq.service;

import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;
import com.zq.bean.order.OrderRefundDto;
import com.zq.bean.order.OrderSaveDto;
import com.zq.mapper.OrderMapper;
import com.zq.mapper.OrderStockMapper;
import com.zq.service.impl.OrderServiceImpl;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderOperationImpl {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderStockMapper orderStockMapper;
    @Autowired
    private OrderPayService orderPayService;

    @Transactional(rollbackFor = Exception.class)
    public Map<Object,Object> operation(OrderSaveDto orderParam) throws Exception {
        //封装数据
        Order order = new Order();
        BeanUtils.copyProperties(orderParam, order);
        String str = orderService.saveOrder(order);
        if(!"1".equals(str)){
            throw new Exception("保存订单失败");
        }
        //扣减库存
        int stock= orderStockMapper.updateStockDel(order);
        if(stock != 1){
            throw new Exception("扣减库存失败");
        }
        //调用支付接口
        String pay = orderPayService.pay(order);
        if(pay == null || "".equals(pay)){
            throw new Exception("调用微信接口失败");
        }
        Map<Object,Object> map = new HashMap<>();
        map.put("orderId",orderParam.getOrderId());
        map.put("payUrl",pay);
        map.put("orderStatus",orderParam.getOrderStatus());
        map.put("payTime",new Date());
        return map;
    }
    public String refundOrder(OrderRefundDto orderRefundDto) throws Exception {
        OrderParam orderParam = new OrderParam();
        BeanUtils.copyProperties(orderRefundDto, orderParam);
        //查询原订单
        List<Order> order = orderService.findOrder(orderParam);
        if(order == null || order.size() == 0){
            return "原订单不存在";
        }
        if(order.get(0).getOrderMoney().compareTo(orderRefundDto.getRefundAmount()) != 0){
            return "退款金额和原订单金额不一致";
        }
        //插入退款表
        orderService.refundOrder(orderRefundDto);
        return "退款申请成功";
    }

}
