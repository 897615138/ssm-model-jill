package jill.payment;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import jill.payment.entity.UserInfo;
import jill.payment.mapper.UserInfoMapper;
import jill.payment.service.IUserInfoService;


@Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

@Autowired
private IUserInfoService iUserMapper;

    @Test
    public void select(){

        List<UserInfo> userInfos = iUserMapper.list();
        System.out.println(userInfos);
    }

    @Test
    public void uuid() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-", "");
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        System.out.println(s);
    }
}
