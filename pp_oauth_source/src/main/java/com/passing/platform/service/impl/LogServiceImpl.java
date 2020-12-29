package com.passing.platform.service.impl;

import com.passing.platform.dao.LogMapper;
import com.passing.platform.domain.Log;
import com.passing.platform.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired(required = false)
    private LogMapper logMapper;

    @Override
    public int insert(Log record) {
        return logMapper.insert(record);
    }
}
