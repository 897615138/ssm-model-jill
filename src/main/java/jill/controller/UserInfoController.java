package jill.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @RequestMapping("register/{userName}/{userNickname}/{userEmail}/{userPhone}/{userPassword}")
    public String register(
            @PathVariable String userName,
            @PathVariable String userPassword,
            @PathVariable String userNickname,
            @PathVariable String userEmail,
            @PathVariable String userPhone){
        System.out.println(userName);
        System.out.println(userPassword);
        System.out.println(userNickname);
        System.out.println(userEmail);
        System.out.println(userPhone);
        return "register success";
    }
}
