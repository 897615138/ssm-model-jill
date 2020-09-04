package jill.payment.service.impl;

import java.util.List;

import jill.payment.entity.ProductInfo;
import jill.payment.entity.UserInfo;
import jill.payment.mapper.ProductInfoMapper;
import jill.payment.service.IProductInfoService;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jill
 * @since 2020-09-03
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {
    @Autowired
    private IProductInfoService iProductInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<ProductInfo> getProList() throws AppException {
        List<ProductInfo> list = iProductInfoService.list();
        if (list.size()==0){
            throw new AppException(ResultCode.PRO_NONE);
        }else{
        return list;}
    }
    @Override
    public void updatePro(ProductInfo productInfo) throws AppException{
        UpdateWrapper<ProductInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pro_id",productInfo.getProId())
                .set("pro_name", productInfo.getProName())
                .set("user_id",productInfo.getUserId());
        boolean pro_id = iProductInfoService.update(updateWrapper);
        if (!pro_id){
            throw new AppException(ResultCode.UPDATE_PRO_FAIL);
        }
    }
}
