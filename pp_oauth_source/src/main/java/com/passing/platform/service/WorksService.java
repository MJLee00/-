package com.passing.platform.service;

import com.alibaba.fastjson.JSONObject;
import com.passing.platform.domain.Works;

import java.util.List;

public interface WorksService {
    int createWorks(Works works);
    boolean changeWorks(JSONObject jsonObject);
    String returnFilepath(String type, int worksId);
    Works selectWorks(int worksId);

    List<Works> selectWorkByTeacherid(int id, int start, int pagesize);
    int selectCountByTeacherid(int id);
}
