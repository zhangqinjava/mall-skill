package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
@Getter
@Setter
@Data
public class OrderSaveDto {
    @NotEmpty(message = "订单不能为空")
    private String orderId;
    @NotEmpty(message = "订单日期不能为空")
    private String orderDate;
    private BigDecimal orderMoney=new BigDecimal(0);
    private int orderStatus;
    private String payId;
    private int payStatus;
    @NotEmpty(message = "商品号不能为空")
    private String goodId;
    @NotEmpty(message = "商品数量不能为空")
    private int goodNum;
    private BigDecimal goodPrice=new BigDecimal(0);
    @NotEmpty(message = "商品名称不能为空")
    private String goodName;
    @NotEmpty(message="用户不能为空")
    private String userId;
    @NotEmpty(message="收件人名称")
    private String receiver_name;
    @NotEmpty(message="收件人电话")
    private String receiver_phone;
    @NotEmpty(message="收件人地址")
    private String receiver_address;
    private String remark;
}
