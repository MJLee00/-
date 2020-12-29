package com.ucenter.service;

import com.common.model.ucenter.SysUser;
import com.ucenter.dao.UserMapper;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    public SysUser findUserByAccount(String account){return userMapper.findByAccount(account);}
}
