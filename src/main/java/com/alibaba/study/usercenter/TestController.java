package com.alibaba.study.usercenter;

import com.alibaba.study.usercenter.dao.user.UserMapper;
import com.alibaba.study.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: wjy
 * @Date: 2019/12/29 21:59
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("testInsert")
    public User testInsert() {
        User user = new User();
        //设置必要的值
        //设置头像的网址 积分，创建时间，修改时间
        user.setAvatarUrl("xxx");
        user.setBonus(300);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        // insert 和 insertSelective
        this.userMapper.insertSelective(user);
        return user;
    }

    @GetMapping("test")
    public String gettingStarted(){
        return "hello_world";
    }

}
