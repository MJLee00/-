package com.passing.platform.dao;

import com.passing.platform.domain.Courseintro;

import java.util.List;

public interface CourseintroMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courseintro record);

    int insertSelective(Courseintro record);

    Courseintro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courseintro record);

    int updateByPrimaryKey(Courseintro record);

    List<Courseintro> selectAllCourse(int start, int pagesize);

    int selectAllCount();
    List<Courseintro> selectCourseByTeacherid(int teacherid, int start, int pagesize);
    int selectCountByTeacherid(int id);
}