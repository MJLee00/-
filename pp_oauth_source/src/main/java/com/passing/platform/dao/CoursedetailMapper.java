package com.passing.platform.dao;

import com.passing.platform.domain.Coursedetail;

public interface CoursedetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coursedetail record);

    int insertSelective(Coursedetail record);

    Coursedetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coursedetail record);

    int updateByPrimaryKey(Coursedetail record);
}