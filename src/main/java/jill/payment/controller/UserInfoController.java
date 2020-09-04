package jill.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jill.payment.entity.UserInfo;
import jill.payment.service.impl.UserInfoServiceImpl;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;
import jill.util.result.ResultEntity;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author jill
 * @since 2020-09-01
 */
@RestController
//@RequestMapping("/payment/user-info")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoService;

    @RequestMapping("register")
    public ResultEntity register(UserInfo user) {
        ResultEntity<Object> resultEntity;
        try {
            userInfoService.checkUserName(user);
            userInfoService.checkMail(user);
            userInfoService.checkPhone(user);
            userInfoService.register(user);
            resultEntity = ResultEntity.SUCCESS(ResultCode.REGISTER_SUCCESS);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }

    /**
     * 用户名重复验证
     *
     * @param user 用户信息
     * @return 返回
     */
    @RequestMapping("checkUserName")
    public ResultEntity checkUserName(UserInfo user) {
        System.out.println(user);
        ResultEntity<Object> resultEntity;
        try {
            userInfoService.checkUserName(user);
            resultEntity = ResultEntity.SUCCESS(ResultCode.REGISTER_USERNAME);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }

    /**
     * 登录
     *
     * @param user 用户信息
     * @return 返回结果
     */
    @RequestMapping("login")
    public ResultEntity login(UserInfo user) {
        System.out.println(user);
        ResultEntity<Object> resultEntity;
        try {
            userInfoService.login(user);
            resultEntity = ResultEntity.SUCCESS(ResultCode.LOGIN_SUCCESS);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }

    /**
     * 邮箱重复验证
     *
     * @param user 用户信息
     * @return 返回结果
     */
    @RequestMapping("checkMail")
    public ResultEntity checkMail(UserInfo user) {
        System.out.println(user);
        ResultEntity<Object> resultEntity;
        try {
            userInfoService.checkMail(user);
            resultEntity = ResultEntity.SUCCESS(ResultCode.REGISTER_MAIL);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }

    /**
     * 手机号重复验证
     *
     * @param user 用户信息
     * @return 返回结果
     */
    @RequestMapping("checkPhone")
    public ResultEntity checkPhone(UserInfo user) {
        System.out.println(user);
        ResultEntity<Object> resultEntity;
        try {
            userInfoService.checkPhone(user);
            resultEntity = ResultEntity.SUCCESS(ResultCode.REGISTER_PHONE);
            System.out.println(resultEntity);
        } catch (AppException e) {
            resultEntity = ResultEntity.EXCEPTION(e);
        }
        System.out.println(resultEntity);
        return resultEntity;
    }

}
