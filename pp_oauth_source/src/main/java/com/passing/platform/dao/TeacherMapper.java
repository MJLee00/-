package com.passing.platform.dao;

import com.passing.platform.domain.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);




    int selectAllCount();
}