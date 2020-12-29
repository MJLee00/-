package com.passing.platform.service.impl;

import com.passing.platform.dao.CoursedetailMapper;
import com.passing.platform.domain.Coursedetail;
import com.passing.platform.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailServiceImpl implements CourseDetailService {
    @Autowired(required = false)
    private CoursedetailMapper coursedetailMapper;

    @Override
    public Coursedetail getCourseDetailById(int id) {
        return coursedetailMapper.selectByPrimaryKey(id);
    }
}
