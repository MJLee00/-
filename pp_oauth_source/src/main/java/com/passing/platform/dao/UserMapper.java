package com.passing.platform.dao;

import com.passing.platform.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    //自定义
    int verifyPassword(String account, String password);

    int getType(String account, String password);

    int selectUserByAccount(String account);

    int getIdByAccountAndPwd(String account, String pwd);

    User getUserTeacherById(int id);

    List<User> getAllUserTeacher(int start, int pagesize);
}