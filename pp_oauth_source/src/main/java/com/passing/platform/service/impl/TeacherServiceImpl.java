package com.passing.platform.service.impl;

import com.passing.platform.dao.TeacherMapper;
import com.passing.platform.domain.Teacher;
import com.passing.platform.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired(required = false)
    private TeacherMapper teacherMapper;

    @Override
    public boolean insert(Teacher teacher){

        return teacherMapper.insert(teacher)>0?true:false;
    }


    @Override
    public int selectAllCount() {
        return teacherMapper.selectAllCount();
    }
}
