package com.passing.platform.service;

import com.passing.platform.domain.Testing;

import java.util.List;

public interface TestingService {
    List<Testing> getAllTesting(int start, int size, int courseid);

    int getCount();


}
