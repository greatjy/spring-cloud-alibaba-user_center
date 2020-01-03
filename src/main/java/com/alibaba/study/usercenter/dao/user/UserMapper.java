package com.alibaba.study.usercenter.dao.user;

import com.alibaba.study.usercenter.domain.entity.user.User;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}