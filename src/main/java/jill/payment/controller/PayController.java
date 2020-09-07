package jill.payment.controller;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jill.util.result.ResultEntity;

@RestController
public class PayController {
    @RequestMapping("/wxpay/notify_url")
    public String getNotify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获得微信发送来的诱求，从请求消意中获得数据。│
        ServletInputStream is = request.getInputStream();
        byte[]b = new byte[1024];
        int len=0;
        while((len = is.read(b))!=-1) {
            String str = new String(b, 0, len);
            System.out.print(str);
        }
        ResultEntity resultEntity = null;
        System.out.println("success");
        String msg="宝宝小猪仔";
//        response.getWriter().write("<xml>\n" +
//                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
//                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
//                "</xml>");
//        try {
//            List<ProductInfo> proList = iProductInfoService.getProList();
//            resultEntity = ResultEntity.SUCCESS(ResultCode.PRO_LIST,proList);
//            System.out.println(resultEntity);
//        } catch (AppException e) {
//            resultEntity = ResultEntity.EXCEPTION(e);
//        }
//        System.out.println(resultEntity);
        return msg;
    }
}
