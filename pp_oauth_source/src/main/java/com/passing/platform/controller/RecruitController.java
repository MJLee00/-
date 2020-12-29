package com.passing.platform.controller;

import com.passing.platform.domain.Recruit;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.RecruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecruitController {
    @Autowired(required = false)
    private RecruitServiceImpl recruitService;

    @ResponseBody
    @GetMapping("/recruit")
    public Rdatatype getRecruit(@RequestParam(value = "id")int id, @RequestParam(value = "start",defaultValue = "0")int start,
                              @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= recruitService.selectCountByTeacherid(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Recruit> data=recruitService.selectRecruitByTeacherid(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }

    @ResponseBody
    @GetMapping("/recruit/getall")
    public Rdatatype getRecruits( @RequestParam(value = "start",defaultValue = "0")int start,
                                 @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= recruitService.selectAllCount();
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Recruit> data=recruitService.selectAllRecruit(start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }
}
