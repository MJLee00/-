package com.passing.platform.dao;

import com.passing.platform.domain.Applyteacher;

public interface ApplyteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Applyteacher record);

    int insertSelective(Applyteacher record);

    Applyteacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Applyteacher record);

    int updateByPrimaryKey(Applyteacher record);
}