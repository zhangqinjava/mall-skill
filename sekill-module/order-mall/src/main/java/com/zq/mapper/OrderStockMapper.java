package com.zq.mapper;

import com.zq.bean.order.OrderParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderStockMapper {
    int updateStockIncr(OrderParam orderParam);
    int updateStockDel(OrderParam orderParam);

}
