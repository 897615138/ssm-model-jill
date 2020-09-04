package jill.payment.service;

import java.util.List;

import jill.payment.entity.ProductInfo;
import jill.payment.entity.UserInfo;
import jill.util.exception.AppException;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jill
 * @since 2020-09-03
 */
public interface IProductInfoService extends IService<ProductInfo> {
    List<ProductInfo> getProList() throws AppException;

    void updatePro(ProductInfo productInfo) throws AppException;

    void newPro(ProductInfo product)throws AppException;

    void deletePro(ProductInfo product) throws AppException;
}
