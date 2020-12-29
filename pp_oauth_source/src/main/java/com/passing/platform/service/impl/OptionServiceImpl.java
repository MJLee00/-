package com.passing.platform.service.impl;

import com.passing.platform.dao.OptionMapper;
import com.passing.platform.domain.Option;
import com.passing.platform.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired(required = false)
    private OptionMapper optionMapper;

    @Override
    public List<Option> getOptionByTopicId(int topicid) {
        return  optionMapper.getOptionsByTopicId(topicid);
    }
}
