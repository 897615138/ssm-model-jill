package jill.payment;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import jill.payment.entity.UserInfo;
import jill.payment.service.IUserInfoService;
import jill.util.exception.AppException;
import jill.util.result.ResultCode;


@Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

@Autowired
private IUserInfoService userInfoService;

    @Test
    public void select(){

        List<UserInfo> userInfos = userInfoService.list();
        System.out.println(userInfos);
    }

    @Test
    public void uuid() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-", "");
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        System.out.println(s);
    }
    @Test
    public void checkUserName() {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_name",1));
        System.out.println(userName);
    }
    @Test
    public void checkMail() throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_email","1@qq.com"));
        System.out.println(userName);
    }
    @Test
    public void checkPhone() throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(queryWrapper.eq("user_phone","1"));
        System.out.println(userName);
    }

    @Test
    public void login() throws AppException {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        List<UserInfo> userName = userInfoService.list(
                queryWrapper.eq("user_name","1").
                        or().eq("user_email","1").
                        or().eq("user_phone","233"));
        System.out.println(userName);
    }
}
