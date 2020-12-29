package com.passing.platform.service.impl;

import com.passing.platform.dao.CoursewareMapper;
import com.passing.platform.domain.Courseware;
import com.passing.platform.service.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursewareServiceImpl  implements CoursewareService {
    @Autowired(required =  false)
    private CoursewareMapper coursewareMapper;

    @Override
    public List<Courseware> selectAllCourseWare(int start, int pagesize,int courseid) {
        return coursewareMapper.selectAllCourseWare(start,pagesize,courseid);
    }

    @Override
    public Courseware getCoursewareById(int id) {
        return  coursewareMapper.selectByPrimaryKey(id);
    }

    @Override
    public int selectAllCount() {
        return coursewareMapper.selectAllCount();
    }
}
