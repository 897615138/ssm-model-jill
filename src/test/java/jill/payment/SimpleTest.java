package jill.payment;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import jill.payment.entity.ProductInfo;
import jill.payment.entity.UserInfo;
import jill.payment.service.IProductInfoService;
import jill.payment.service.IUserInfoService;
import jill.util.exception.AppException;


@Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

@Autowired
private IUserInfoService userInfoService;
@Autowired
private IProductInfoService productInfoService;

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

    @Test
    public void proUpdate() throws AppException{
        QueryWrapper<ProductInfo> queryWrapper=new QueryWrapper<>();
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProId("1");
        productInfo.setProName("test");
       productInfo.setUserId("f5f807652c514c82b9e2d42f43a10a71");
       productInfo.setProDelete(0);
        UpdateWrapper<ProductInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pro_id","1").set("pro_name", "test").set("pro_delete",1);
        boolean pro_id = productInfoService.update(updateWrapper);
        System.out.println(pro_id);
//        LambdaUpdateChainWrapper<User> lambdaUpdateChainWrapper = new LambdaUpdateChainWrapper<>(userMapper);
//
//        boolean update = lambdaUpdateChainWrapper.eq(User::getRealName, "shimin").set(User::getAge, 33).update();
//        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        lambdaUpdateWrapper.eq(User::getRealName, "shimin").set(User::getAge, 34);
//
//        Integer rows = userMapper.update(null, lambdaUpdateWrapper);


    }
    @Test
    public void newPro() throws AppException{
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProId("test");
        productInfo.setProName("test");
        productInfo.setUserId("f5f807652c514c82b9e2d42f43a10a71");
        productInfo.setProDelete(0);
        boolean save = productInfoService.save(productInfo);
        System.out.println(save);
    }
    @Test
    public void pageTest() throws AppException{
//        PageHelper.startPage(2,5);
//        List<UserInfo> list = productInfoService.getProByPage();//这个查询会分页
//        System.out.println(list);
//        Page<ProductInfo> page = productInfoService.page(new Page<>(2, 1));
//        System.out.println(page);
        Page<Map<String, Object>> mapPage = productInfoService.pageMaps(new Page<>(2, 5));
        System.out.println(mapPage);
    }
}