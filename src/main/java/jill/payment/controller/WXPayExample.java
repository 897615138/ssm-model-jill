package jill.payment.controller;

import java.util.HashMap;
import java.util.Map;

import jill.config.MyConfig;
import jill.wxpay.sdk.WXPay;

public class WXPayExample {
    public static void main(String[] args) throws Exception {

        MyConfig config = new MyConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "支付");
        data.put("out_trade_no", "20200907105959566666666");
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", " http://fubvwk.natappfree.cc/wxpay/notify_url");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
