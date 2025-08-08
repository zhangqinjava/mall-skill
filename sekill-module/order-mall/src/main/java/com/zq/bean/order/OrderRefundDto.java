package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Getter
@Setter
public class OrderRefundDto {
    @NotEmpty(message="退款单号不能为空")
    private String  refundNo;
    @NotEmpty(message="退款时间不能为空")
    private String  refundDate;
    @NotEmpty(message="原订单不能为空")
    private String orderId;
    @NotEmpty(message="原订单日期不能为空")
    private String orderDate;
    @NotEmpty(message="退款类型不能为空")
    private String  refundType;
    @NotEmpty(message="退款金额不能为空")
    private BigDecimal refundAmount=new BigDecimal(0);
    private String  refundStatus;
    @NotEmpty(message="退款理由不能为空")
    private String  refundReason;
}
