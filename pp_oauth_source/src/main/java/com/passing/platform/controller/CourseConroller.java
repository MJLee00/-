package com.passing.platform.controller;

import com.passing.platform.domain.Courseintro;
import com.passing.platform.service.impl.CourseIntroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseConroller {
    @Autowired
    private CourseIntroServiceImpl courseIntroService;


    @RequestMapping(value = "/courseIntro", method = RequestMethod.GET)
    public  Object getHotCourse(@RequestParam(value = "start" ,defaultValue = "0")int start,
                                @RequestParam(value = "pagesize",defaultValue = "4") int pagesize){

        int total= courseIntroService.getCount();
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Courseintro> data=courseIntroService.getCourseIntroToHome(start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        return res;

    }

    @RequestMapping(value = "/courseIntro/id/{id}",method = RequestMethod.GET)
    public Object getCourseById(@PathVariable("id") String id){
        return courseIntroService.getCourseById(Integer.parseInt( id));
    }

    @GetMapping("/courseIntro/getByTeacher")
    public Object getCourseIntro(@RequestParam(value = "id")int id,
                                 @RequestParam(value = "start",defaultValue = "0") int start,
                                 @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        int total= courseIntroService.getCountByTeacherid(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Courseintro> data=courseIntroService.getCourseByTeacherId(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }
}
