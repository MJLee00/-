package com.passing.platform.service.impl;

import com.passing.platform.dao.RecruitMapper;
import com.passing.platform.domain.Recruit;
import com.passing.platform.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired(required = false)
    private RecruitMapper recruitMapper;

    @Override
    public List<Recruit> selectRecruitByTeacherid(int id, int start, int pagesize) {
        return recruitMapper.selectRecruitByTeacherid(id,start,pagesize);
    }

    @Override
    public int selectCountByTeacherid(int id) {
        return recruitMapper.selectCountByTeacherid(id);
    }

    @Override
    public List<Recruit> selectAllRecruit(int start, int pagesize) {
        return recruitMapper.selectAllRecruit(start,pagesize);
    }

    @Override
    public int selectAllCount() {
        return recruitMapper.selectAllCount();
    }

    @Override
    public Recruit selectByPrimaryKey(Integer id) {
        return recruitMapper.selectByPrimaryKey(id);
    }
}
