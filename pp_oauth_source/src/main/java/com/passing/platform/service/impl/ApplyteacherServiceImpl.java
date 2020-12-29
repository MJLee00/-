package com.passing.platform.service.impl;

import com.passing.platform.dao.ApplyteacherMapper;
import com.passing.platform.domain.Applyteacher;
import com.passing.platform.service.ApplyteacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyteacherServiceImpl implements ApplyteacherService {

    @Autowired(required = false)
    private ApplyteacherMapper applyteacherMapper;

    @Override
    public int insert(Applyteacher record) {
        return applyteacherMapper.insert(record);
    }

    @Override
    public Applyteacher selectByPrimaryKey(Integer id) {
        return applyteacherMapper.selectByPrimaryKey(id);
    }
}
