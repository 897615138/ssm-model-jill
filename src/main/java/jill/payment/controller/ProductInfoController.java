package jill.payment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import jill.payment.entity.ProductInfo;
import jill.payment.service.IProductInfoService;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;
import jill.util.result.ResultEntity;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jill
 * @since 2020-09-03
 */
@RestController
//@RequestMapping("/payment/product-info")
public class ProductInfoController {
    @Autowired
    private IProductInfoService iProductInfoService;
    @RequestMapping("/pro/getList")
    public ResultEntity getProList(){
        ResultEntity resultEntity;
        try {
            List<ProductInfo> proList = iProductInfoService.getProList();
            resultEntity = ResultEntity.SUCCESS(ResultCode.PRO_LIST,proList);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }
    @RequestMapping("/pro/update")
    public ResultEntity updatePro(ProductInfo product){
        ResultEntity resultEntity;
        System.out.println(product);
        try {
            iProductInfoService.updatePro(product);
            resultEntity = ResultEntity.SUCCESS(ResultCode.UPDATE_PRO);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }
    @RequestMapping("/pro/new")
    public ResultEntity newPro(ProductInfo product){
        ResultEntity resultEntity;
        System.out.println(product);
        try {
            iProductInfoService.newPro(product);
            resultEntity = ResultEntity.SUCCESS(ResultCode.CREATE_PRO);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }
    @RequestMapping("/pro/delete")
    public ResultEntity deletePro(ProductInfo product){
        ResultEntity resultEntity;
        System.out.println(product);
        try {
            iProductInfoService.deletePro(product);
            resultEntity = ResultEntity.SUCCESS(ResultCode.DELETE_PRO);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }
}

