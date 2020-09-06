package jill.payment.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import jill.payment.entity.ProductInfo;
import jill.payment.entity.UserInfo;
import jill.payment.mapper.ProductInfoMapper;
import jill.payment.service.IProductInfoService;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jill
 * @since 2020-09-03
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<ProductInfo> getProList() throws AppException {
        List<ProductInfo> list = productInfoService.list();
        if (list.size() == 0) {
            throw new AppException(ResultCode.PRO_NONE);
        } else {
            return list;
        }
    }

    @Override
    public void updatePro(ProductInfo productInfo) throws AppException {
        UpdateWrapper<ProductInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pro_id", productInfo.getProId())
                .set("pro_name", productInfo.getProName())
                .set("user_id", productInfo.getUserId());
        boolean pro_id = productInfoService.update(updateWrapper);
        if (!pro_id) {
            throw new AppException(ResultCode.UPDATE_PRO_FAIL);
        }
    }

    @Override
    public void newPro(ProductInfo product) throws AppException {
        System.out.println(product);
        product.setProId(UUID.randomUUID().toString().replace("-", ""));
        product.setProDelete(0);
        product.setUserId(product.getUserId());
        product.setProName(product.getProName());
        boolean save = productInfoService.save(product);
        if (!save) {
            throw new AppException(ResultCode.CREATE_PRO_FAIL);
        }
    }

    @Override
    public void deletePro(ProductInfo product) throws AppException {
        UpdateWrapper<ProductInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pro_id", product.getProId())
                .set("pro_delete", 1);
        boolean pro_id = productInfoService.update(updateWrapper);
        if (!pro_id) {
            throw new AppException(ResultCode.DELETE_PRO_FAIL);
        }
    }
}
