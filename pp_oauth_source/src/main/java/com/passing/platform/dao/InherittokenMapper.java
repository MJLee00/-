package com.passing.platform.dao;

import com.passing.platform.domain.Inherittoken;

import java.util.List;

public interface InherittokenMapper {
    int deleteByPrimaryKey(Integer inherittokenid);

    int insert(Inherittoken record);

    int insertSelective(Inherittoken record);

    Inherittoken selectByPrimaryKey(Integer inherittokenid);

    int updateByPrimaryKeySelective(Inherittoken record);

    int updateByPrimaryKeyWithBLOBs(Inherittoken record);

    int updateByPrimaryKey(Inherittoken record);

    List<Inherittoken> selectAllInherittoken(int id, int start, int pagesize);

    int selectAllCountByUser(int id);

}