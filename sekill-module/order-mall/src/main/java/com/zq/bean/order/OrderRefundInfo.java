package com.zq.bean.order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class OrderRefundInfo {
    private String  id;
    private String  refundNo;
    private String  refundDate;
    private String  refundType;
    private String  refundAmount;
    private String  refundStatus;
    private String  refundReason;
    private String create_time;
    private String update_time;
}
