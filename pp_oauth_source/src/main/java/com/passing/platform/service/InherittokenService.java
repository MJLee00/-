package com.passing.platform.service;

import com.passing.platform.domain.Inherittoken;

import java.util.List;

public interface InherittokenService {
    int createInherittoken(Inherittoken inherittoken);
    List<Inherittoken> selectAllInherittoken(int id, int start, int pagesize);

    int selectAllCountByUser(int id);
}
