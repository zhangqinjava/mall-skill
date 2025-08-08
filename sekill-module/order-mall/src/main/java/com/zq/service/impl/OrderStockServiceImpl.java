package com.zq.service.impl;

import com.zq.bean.order.OrderParam;
import com.zq.service.OrderStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;

@Service
public class OrderStockServiceImpl implements OrderStockService {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Override
    public int updateOrderStock(OrderParam orderParam) {
        threadPoolExecutor.execute(()->{
            //扣减库存
        });
        return 0;
    }

}
