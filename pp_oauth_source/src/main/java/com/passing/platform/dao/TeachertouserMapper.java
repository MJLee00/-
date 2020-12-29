package com.passing.platform.dao;

import com.passing.platform.domain.Teachertouser;
import com.passing.platform.domain.User;

import java.util.List;

public interface TeachertouserMapper {
    int deleteByPrimaryKey(Integer idteachertouser);

    int insert(Teachertouser record);

    int insertSelective(Teachertouser record);

    Teachertouser selectByPrimaryKey(Integer idteachertouser);

    int updateByPrimaryKeySelective(Teachertouser record);

    int updateByPrimaryKey(Teachertouser record);

    List<User> getStudentsByTeacherId(int id, int start, int pagesize);
    int getStudentCountByTeacherId(int id);

    List<Teachertouser> getTeacherByStudentId(int id, int start, int pagesize);
    int getTeacherCountByStudentId(int id);

}