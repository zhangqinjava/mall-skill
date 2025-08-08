package com.zq.service;

import com.zq.bean.SkuInfo;

import java.util.List;

public interface SkuInfoService {
    String saveSkuInfo(SkuInfo skuInfo);
    String updateSkuInfo(SkuInfo skuInfo);
    String deleteSkuInfo(String skuId);
    List<SkuInfo> getSkuInfo(String skuId);
}
