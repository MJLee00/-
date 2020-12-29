package com.passing.platform.service;

import com.passing.platform.domain.Teachertouser;
import com.passing.platform.domain.User;

import java.util.List;

public interface TeachertouserService {
    List<User> getStudentsByTeacherId(int id, int start, int pagesize);
    int getStudentCountByTeacherId(int id);


    List<Teachertouser>  getTeacherByStudentId(int id, int start, int pagesize);
    int getTeacherCountByStudentId(int id);
}
