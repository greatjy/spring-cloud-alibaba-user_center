package com.alibaba.study.usercenter.service.user;

import com.alibaba.study.usercenter.dao.user.UserMapper;
import com.alibaba.study.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wjy
 * @Date: 2020/1/2 16:07
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  根据id返回用户
     */
    public User findUserById(Integer id){
        // 自动生成select * from user where id = #{id}
        return userMapper.selectByPrimaryKey(id);
    }

}
