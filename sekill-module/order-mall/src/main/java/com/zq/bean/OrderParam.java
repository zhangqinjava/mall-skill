package com.zq.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderParam {
    private String orderId;
    private String orderStartDate;
    private String orderEndDate;
    private BigDecimal orderMoney=new BigDecimal(0);
    private int orderStatus;
    private String payId;
    private int payStatus;
    private String goodsId;
    private BigDecimal goodPrice=new BigDecimal(0);
    private String goodsName;
}
