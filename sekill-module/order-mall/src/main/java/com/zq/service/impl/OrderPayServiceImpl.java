package com.zq.service.impl;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAPublicKeyConfig;
import com.wechat.pay.java.service.payments.nativepay.NativePayService;
import com.wechat.pay.java.service.payments.nativepay.model.Amount;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayRequest;
import com.wechat.pay.java.service.payments.nativepay.model.PrepayResponse;
import com.zq.bean.order.Order;
import com.zq.bean.order.OrderParam;
import com.zq.service.OrderPayService;
import org.springframework.stereotype.Service;

@Service
public class OrderPayServiceImpl implements OrderPayService {
    /** 商户号 */
    public static String merchantId = "190000****";
    /** 商户API私钥路径 */
    public static String privateKeyPath = "/Users/yourname/your/path/apiclient_key.pem";
    /** 商户证书序列号 */
    public static String merchantSerialNumber = "5157F09EFDC096DE15EBE81A47057A72********";
    /** 商户APIV3密钥 */
    public static String apiV3Key = "...";
    @Override
    public String pay(Order orderParam) {
        Config config =
                new RSAPublicKeyConfig.Builder()
                        .merchantId(merchantId)
                        .privateKeyFromPath(privateKeyPath)
                        .publicKeyFromPath("publicKeyPath")
                        .publicKeyId("publicKeyId")
                        .merchantSerialNumber(merchantSerialNumber)
                        .apiV3Key(apiV3Key)
                        .build();
//        // 构建service
        NativePayService service = new NativePayService.Builder().config(config).build();
//         request.setXxx(val)、、设置所需参数，具体参数可见Request定义
        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(Integer.valueOf(orderParam.getOrderMoney().toString()));
        request.setAmount(amount);
        request.setAppid("wxa9d9651ae******");
        request.setMchid("190000****");
        request.setDescription("测试商品标题");
        request.setNotifyUrl("https://notify_url");
        request.setOutTradeNo("out_trade_no_001");
        // 调用下单方法，得到应答
        PrepayResponse response = service.prepay(request);
//        // 使用微信扫描 code_url 对应的二维码，即可体验Native支付
//        System.out.println(response.getCodeUrl());
        return response.getCodeUrl();
    }
}
