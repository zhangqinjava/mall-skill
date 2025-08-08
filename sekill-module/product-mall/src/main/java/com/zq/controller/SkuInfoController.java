package com.zq.controller;

import com.mall.common.exception.EnumCode;
import com.mall.common.waapper.Result;
import com.mall.common.waapper.Wrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sku")
public class SkuInfoController {
    public Result saveSkuInfo(String skuId){
        return Wrapper.wrap(EnumCode.SUCCESS.getCode(),"");
    }
    public Result delSkuInfo(String skuId){
        return null;
    }
    public Result updateSkuInfo(String skuId){
        return null;
    }

}
