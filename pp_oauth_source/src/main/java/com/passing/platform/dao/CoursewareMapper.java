package com.passing.platform.dao;

import com.passing.platform.domain.Courseware;

import java.util.List;

public interface CoursewareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    Courseware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKey(Courseware record);

    List<Courseware> selectAllCourseWare(int start, int pagesize, int courseid);

    int selectAllCount();
}