package jill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jill.dao.IUserMapper;

@RestController
@RequestMapping("/user")
public class Test {
    @Autowired
    IUserMapper userService;
    @GetMapping("/{id}")
    public void test(@PathVariable("id") Long id) {
        System.out.println(id);
    }
}
