package com.passing.platform.service;


import com.passing.platform.domain.User;

import java.util.List;

public interface UserService {

    boolean verifypwd(String uid, String pwd);

    int getType(String uid, String pwd);

    boolean insertUser(User u);

    int selectUserByAccount(String account);

    int selectUserIdByAccountAndPwd(String id, String pwd);

    User getUserTeacherById(int id);

    List<User> getAllUserTeacher(int start, int pagesize);


}
