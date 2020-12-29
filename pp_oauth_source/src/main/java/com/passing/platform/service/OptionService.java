package com.passing.platform.service;

import com.passing.platform.domain.Option;

import java.util.List;

public interface OptionService {
    List<Option> getOptionByTopicId(int topicid);
}
