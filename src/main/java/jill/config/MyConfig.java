package jill.config;

import java.io.InputStream;

import jill.payment.service.impl.MyWXPayDomain;
import jill.wxpay.sdk.IWXPayDomain;
import jill.wxpay.sdk.WXPayConfig;

public class MyConfig extends WXPayConfig {
    /**
     * 获取 App ID
     *
     * @return App ID
     */
    @Override
    public String getAppID() {
        //TODO 接入
        return "wx632c8f211f8122c6";
    }

    /**
     * 获取 Mch ID
     *
     * @return Mch ID
     */
    @Override
    public String getMchID() {
        //TODO 接入
        return "147984412";
    }

    /**
     * 获取 API 密钥
     *
     * @return API密钥
     */
    @Override
    public String getKey() {
        //TODO 接入
        return "sbNCm1JnevqI36LrEaxFwcaTOhkGxFnC";
    }

    /**
     * 获取商户证书内容
     *
     * @return 商户证书内容
     */
    @Override
    public InputStream getCertStream() {
        return null;
    }

    /**
     * 获取WXPayDomain, 用于多域名容灾自动切换
     *
     * @return
     */
    @Override
    public IWXPayDomain getWXPayDomain() {
        MyWXPayDomain myWXPayDomain =new MyWXPayDomain();
        return myWXPayDomain;
    }
}
