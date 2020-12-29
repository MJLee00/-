package com.passing.platform.dao;

import com.passing.platform.domain.Option;

import java.util.List;

public interface OptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);

    List<Option> getOptionsByTopicId(int topicid);
}