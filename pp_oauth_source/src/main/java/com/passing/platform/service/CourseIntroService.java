package com.passing.platform.service;

import com.passing.platform.domain.Courseintro;

import java.util.List;

public interface CourseIntroService {
    List<Courseintro> getCourseIntroToHome(int start, int pagesize);

    int getCount();

    Courseintro getCourseById(int id);

    List<Courseintro> getCourseByTeacherId(int id, int start, int pagesize);

    int getCountByTeacherid(int id);
}
