package com.passing.platform.service.impl;

import com.passing.platform.dao.TeachertouserMapper;
import com.passing.platform.domain.Teachertouser;
import com.passing.platform.domain.User;
import com.passing.platform.service.TeachertouserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachertouserServiceImpl implements TeachertouserService {
    @Autowired
    private TeachertouserMapper teachertouserMapper;

    @Override
    public List<User> getStudentsByTeacherId(int id,int start,int pagesize) {
        return teachertouserMapper.getStudentsByTeacherId(id, start, pagesize);
    }

    @Override
    public int getStudentCountByTeacherId(int id) {
        return teachertouserMapper.getStudentCountByTeacherId(id);
    }

    @Override
    public  List<Teachertouser>  getTeacherByStudentId(int id, int start, int pagesize) {
        return teachertouserMapper.getTeacherByStudentId(id,start,pagesize);
    }

    @Override
    public int getTeacherCountByStudentId(int id) {
        return teachertouserMapper.getTeacherCountByStudentId(id);
    }
}
