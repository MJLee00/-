package com.passing.platform.service.impl;

import com.passing.platform.Utils.Annotations.OperatorLogAnnotation;
import com.passing.platform.dao.UserMapper;
import com.passing.platform.domain.User;
import com.passing.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    @OperatorLogAnnotation(detail = "test",level = 0)
    public boolean verifypwd(String name, String password) {

        return userMapper.verifyPassword(name, password)>0?true:false;
    }

    @Override
    public int getType(String account,String pwd){
        return  userMapper.getType(account,pwd);
    }

    @Override
    public boolean insertUser(User user){

        return userMapper.insert(user)>0?true:false;
    }
    @Override
    public int selectUserByAccount(String account){

        return  userMapper.selectUserByAccount(account) ;
    }

    @Override
    public int selectUserIdByAccountAndPwd(String id, String pwd) {
        return userMapper.getIdByAccountAndPwd(id,pwd);
    }

    @Override
    public User getUserTeacherById(int id) {
        return userMapper.getUserTeacherById(id);
    }

    @Override
    public List<User> getAllUserTeacher(int start, int pagesize) {
        return  userMapper.getAllUserTeacher(start,pagesize);
    }


}
