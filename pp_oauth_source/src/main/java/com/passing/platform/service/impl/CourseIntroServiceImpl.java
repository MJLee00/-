package com.passing.platform.service.impl;

import com.passing.platform.dao.CourseintroMapper;
import com.passing.platform.domain.Courseintro;
import com.passing.platform.service.CourseIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseIntroServiceImpl implements CourseIntroService {
    @Autowired(required =  false)
    private CourseintroMapper courseintroMapper;
    @Override
    public List<Courseintro> getCourseIntroToHome(int start,int pagesize) {

        return courseintroMapper.selectAllCourse( start, pagesize);
    }

    @Override
    public int getCount() {
        return  courseintroMapper.selectAllCount();
    }

    @Override
    public Courseintro getCourseById(int id) {
        return courseintroMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Courseintro> getCourseByTeacherId(int id, int start, int pagesize) {
        return courseintroMapper.selectCourseByTeacherid(id,start,pagesize);
    }

    @Override
    public int getCountByTeacherid(int id) {
        return  courseintroMapper.selectCountByTeacherid(id);
    }
}
