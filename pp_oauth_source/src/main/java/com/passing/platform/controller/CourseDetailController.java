package com.passing.platform.controller;

import com.passing.platform.service.impl.CourseDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDetailController {
    @Autowired(required = false)
    private CourseDetailServiceImpl courseDetailService;

    @RequestMapping(value = "/courseDetail/id/{id}",method = RequestMethod.GET)
    public Object getCourseDetailById(@PathVariable("id") String id){
        return courseDetailService.getCourseDetailById(Integer.parseInt(id));
    }
}
