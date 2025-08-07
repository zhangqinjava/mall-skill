package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter
@Getter
public class OrderParam {
    private String orderId;
    private String orderStartDate;
    private String orderEndDate;
    private BigDecimal orderMoney=new BigDecimal(0);
    private int orderStatus;
    private String payId;
    private int payStatus;
    private String goodId;
    private int goodNum;
    private BigDecimal goodPrice=new BigDecimal(0);
    private String goodName;
    private String userId;
}
