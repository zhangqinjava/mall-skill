package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Setter
@Getter
public class OrderParam {
    @NotEmpty(message = "订单不能为空")
    private String orderId;
    @NotEmpty(message = "订单开始日期不能为空")
    private String orderStartDate;
    @NotEmpty(message = "订单结束日期不能为空")
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
