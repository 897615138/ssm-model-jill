package jill;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import jill.dao.IUserMapper;
import jill.entity.UserInfo;

@Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

@Autowired
private IUserMapper iUserMapper;

    @Test
    public void select(){

        List<UserInfo> userInfos = iUserMapper.selectList(null);
        System.out.println(userInfos);
    }

}
