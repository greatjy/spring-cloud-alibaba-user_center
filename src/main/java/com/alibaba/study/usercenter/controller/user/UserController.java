package com.alibaba.study.usercenter.controller.user;

import com.alibaba.study.usercenter.domain.entity.user.User;
import com.alibaba.study.usercenter.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wjy
 * @Date: 2020/1/2 16:35
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }


    //测试方法：q?id=1&wxId=aaa
    @GetMapping("q")
    public User queryUser(User user){
        return user;
    }
}
