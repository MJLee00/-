package com.passing.platform.dao;

import com.passing.platform.domain.Recruit;

import java.util.List;

public interface RecruitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recruit record);

    int insertSelective(Recruit record);

    Recruit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recruit record);

    int updateByPrimaryKey(Recruit record);
    List<Recruit> selectRecruitByTeacherid(int id, int start, int pagesize);
    int selectCountByTeacherid(int id);

    List<Recruit> selectAllRecruit(int start, int pagesize);
    int selectAllCount();
}