package com.passing.platform.dao;

import com.passing.platform.domain.Passingtoken;

public interface PassingtokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Passingtoken record);

    int insertSelective(Passingtoken record);

    Passingtoken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passingtoken record);

    int updateByPrimaryKey(Passingtoken record);
}