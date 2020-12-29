package com.passing.platform.service;

import com.passing.platform.domain.Applyteacher;

public interface ApplyteacherService {

    int insert(Applyteacher record);
    Applyteacher selectByPrimaryKey(Integer id);

}
