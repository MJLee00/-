package com.passing.platform.service;

import com.passing.platform.domain.Recruit;

import java.util.List;

public interface RecruitService  {
    List<Recruit> selectRecruitByTeacherid(int id, int start, int pagesize);
    int selectCountByTeacherid(int id);


    List<Recruit> selectAllRecruit(int start, int pagesize);
    int selectAllCount();

    Recruit selectByPrimaryKey(Integer id);

}
