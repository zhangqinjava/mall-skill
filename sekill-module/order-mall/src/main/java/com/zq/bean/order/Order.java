package com.zq.bean.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private String orderId;
    private String orderDate;
    private int orderStatus;
    private BigDecimal orderMoney=new BigDecimal(0);
    private String payId;
    private int payStatus;
    private String payTime;
    private String userId;
    private String goodsId;
    private String goodsName;
    private String goodsNumber;
    private BigDecimal goodsPrice=new BigDecimal(0);
    private String createTime;
    private String updateTime;
}
