package jill.payment.service.impl;

import java.util.List;
import java.util.UUID;

import jill.payment.entity.UserInfo;
import jill.payment.mapper.UserInfoMapper;
import jill.payment.service.IUserInfoService;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author jill
 * @since 2020-09-01
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 注册
     * @param user 注册的用户信息
     * @throws AppException 异常
     */
    @Override
    public void register(UserInfo user) throws AppException {
        //设置id
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        //设置默认头像
        if (user.getUserAvatar() == null) {
            //设置默认图片
            user.setUserAvatar("https://i0.hdslb.com/bfs/album/d5443762fa5d8de838a6c942899311752ccc59bf.png");
        }

        //TODO 头像处理
//        else {
//            //处理前端的图片，进行转换  这里的path 和apiUrl，是配置文件中的 用value注解获取
////            String imageUrl = Common.handleUploadPicture(user.getUserAvatar(),path,apiUrl);
////            log.info("打印imageUrl="+imageUrl);
////            tbItem.setImage(imageUrl);
//        }
        System.out.println(user);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        boolean save = userInfoService.save(user);
        if (!save)throw new AppException(ResultCode.REGISTER_FAIL);
    }

    @Override
    public void checkUserName(UserInfo user) throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_name",user.getUserName()));
       if (userName.size()>0){
           throw new AppException(ResultCode.REGISTER_USERNAME_EXIST);
       }
    }
    @Override
    public void checkMail(UserInfo user) throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_email",user.getUserEmail()));
        if (userName.size()>0){
            throw new AppException(ResultCode.REGISTER_MAIL_EXIST);
        }
    }

    @Override
    public void checkPhone(UserInfo user) throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_phone",user.getUserPhone()));
        if (userName.size()>0){
            throw new AppException(ResultCode.REGISTER_PHONE_EXIST);
        }
    }

    @Override
    public void login(UserInfo user) throws AppException{
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> users = userInfoService.list(
                queryWrapper.eq("user_name",user.getUserName()).
                        or().eq("user_email",user.getUserEmail()).
                        or().eq("user_phone",user.getUserPhone()));
        System.out.println(users);
        if (users.size()==0){
            throw new AppException(ResultCode.LOGIN_USERNAME_NOT_EXIST);
        }else
        {
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            boolean matches = user.getUserPassword().matches(users.get(0).getUserPassword());
            if (!matches){
                throw new AppException(ResultCode.LOGIN_USERNAME_PWD_ERROR);
            }
        }
    }
}
