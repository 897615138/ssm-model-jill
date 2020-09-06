package jill.payment.service.impl;

import jill.wxpay.sdk.IWXPayDomain;
import jill.wxpay.sdk.WXPayConfig;

public class MyWXPayDomain implements IWXPayDomain {
    /**
     * 上报域名网络状况
     *
     * @param domain            域名。 比如：api.mch.weixin.qq.com
     * @param elapsedTimeMillis 耗时
     * @param ex                网络请求中出现的异常。
     *                          null表示没有异常
     *                          ConnectTimeoutException，表示建立网络连接异常
     */
    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    /**
     * 获取域名
     *
     * @param config 配置
     * @return 域名 微信支付域名 是否主域名
     */
    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new DomainInfo("api.mch.weixin.qq.com",true);
    }
}
