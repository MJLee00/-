package com.passing.platform.dao;

import com.passing.platform.domain.Topics;

import java.util.List;

public interface TopicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topics record);

    int insertSelective(Topics record);

    Topics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topics record);

    int updateByPrimaryKey(Topics record);

    List<Topics> getTopicsByTestingId(int testingid);
}