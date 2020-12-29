package com.passing.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.passing.platform.domain.Option;
import com.passing.platform.domain.Topics;
import com.passing.platform.service.impl.OptionServiceImpl;
import com.passing.platform.service.impl.TestingServiceImpl;
import com.passing.platform.service.impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestingController {
    @Autowired(required = false)
    private TestingServiceImpl testingService;
    @Autowired(required = false)
    private TopicServiceImpl topicService;
    @Autowired(required = false)
    private OptionServiceImpl optionService;
    @RequestMapping(value = "/testing",method = RequestMethod.GET)
    public Object getAllTesting(@RequestParam(value = "start",defaultValue = "0")int start,
                                       @RequestParam(value = "pagesize",defaultValue = "4")int pagesize,
                                @RequestParam(value = "id")int id){
        int total= testingService.getCount();
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<com.passing.platform.domain.Testing> data=testingService.getAllTesting(start*_pagesize,pagesize,id);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        return res;

    }
    @RequestMapping(value="/testingOption/",method = RequestMethod.GET)
    public Object getTestingByid(@RequestParam(value="id")int id){
        JSONObject res = new JSONObject();
        res.put("single",new ArrayList<Object>());
        res.put("multi",new ArrayList<Object>());
        res.put("judge",new ArrayList<Object>());
        res.put("blank",new ArrayList<Object>());
        List<Topics> topics= topicService.getTopicsByTestingId(id);
        for(Topics item:topics){
            JSONObject tmp= new JSONObject();
            tmp.put("title",item.getTitle());
            List<Option> options=optionService.getOptionByTopicId(item.getId());
            tmp.put("options",options);
            if(item.getType()==1){
                Object a=res.get("single");
                ((ArrayList)a).add(tmp);
            }
            else if(item.getType()==2){
                ((ArrayList)res.get("multi")).add(tmp);
            }
            else if(item.getType()==3){((ArrayList)res.get("judge")).add(tmp);}
            else {((ArrayList)res.get("blank")).add(tmp);}
        }
        return res;
    }
}
