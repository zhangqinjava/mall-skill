package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Setter
@Getter
@Data
public class OrderUpdateDto {
    @NotEmpty(message="订单号不能为空")
    private String orderId;
    @NotEmpty(message="订单日期不能为空")
    private String orderDate;
    @NotEmpty(message="退款单号不能为空")
    private String refundNo;
    @NotEmpty(message="退款日期不能为空")
    private String refundDate;
    @NotEmpty(message="退款金额不能为空")
    private BigDecimal refundAmount;
    @NotEmpty(message="退款理由不能为空")
    private String refundReason;

}
