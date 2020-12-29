package com.passing.platform.service;

import com.passing.platform.domain.Courseware;

import java.util.List;

public interface CoursewareService {
    List<Courseware> selectAllCourseWare(int start, int pagesize, int courseid);
    int selectAllCount();
    Courseware getCoursewareById(int id);
}
