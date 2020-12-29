package com.passing.platform.service.impl;

import com.passing.platform.dao.TestingMapper;
import com.passing.platform.domain.Testing;
import com.passing.platform.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {
    @Autowired(required = false)
    private TestingMapper testingMapper;

    @Override
    public List<Testing> getAllTesting(int start,int size,int courseid) {
        return testingMapper.selectAllTesting(start,size,courseid);
    }

    @Override
    public int getCount() {
        return  testingMapper.selectAllCount();
    }
}
