package com.passing.platform.dao;

import com.passing.platform.domain.Works;

import java.util.List;

public interface WorksMapper {
    int deleteByPrimaryKey(Integer worksid);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Integer worksid);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKeyWithBLOBs(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectWorkByTeacherid(int teacherid, int start, int pagesize);

    int selectCountByTeacherid(int id);
}