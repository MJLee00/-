package com.passing.platform.service;

import com.passing.platform.domain.Topics;

import java.util.List;

public interface TopicService {
    List<Topics> getTopicsByTestingId(int testingid);
}
