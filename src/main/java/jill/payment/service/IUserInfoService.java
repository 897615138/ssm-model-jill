package jill.payment.service;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import jill.payment.entity.UserInfo;
import jill.util.exception.AppException;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author jill
 * @since 2020-09-01
 */
public interface IUserInfoService extends IService<UserInfo> {
    void register(UserInfo user) throws AppException;
    void checkUserName(UserInfo user) throws AppException;
    void checkMail(UserInfo user) throws AppException;
    void checkPhone(UserInfo user) throws AppException;
    void login(UserInfo user) throws AppException;
}
