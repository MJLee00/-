package com.passing.platform.dao;

import com.passing.platform.domain.Testing;

import java.util.List;

public interface TestingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testing record);

    int insertSelective(Testing record);

    Testing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testing record);

    int updateByPrimaryKey(Testing record);

    List<Testing> selectAllTesting(int start, int pagesize, int courseid);
    int selectAllCount();
}