package jill.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @RequestMapping("register/{userName}/{userPassword}")
    public String register(
            @PathVariable String userName,
            @PathVariable String userPassword
    ){
        System.out.println(userName);
        System.out.println(userPassword);
        return "register success";
    }
}
