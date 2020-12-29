package com.passing.platform.service.impl;

import com.passing.platform.dao.TopicsMapper;
import com.passing.platform.domain.Topics;
import com.passing.platform.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired(required = false)
    private TopicsMapper topicsMapper;

    @Override
    public List<Topics> getTopicsByTestingId(int testingid) {
        return topicsMapper.getTopicsByTestingId(testingid);
    }
}
