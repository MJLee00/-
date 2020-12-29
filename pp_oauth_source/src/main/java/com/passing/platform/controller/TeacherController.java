package com.passing.platform.controller;

import com.passing.platform.domain.User;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.TeacherServiceImpl;
import com.passing.platform.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {
    @Autowired(required = false)
    private TeacherServiceImpl teacherService;
    @Autowired(required = false)
    private UserServiceImpl userService;


    @ResponseBody
    @GetMapping("/teacher/getbyid")
    public Rdatatype getTeacherById(@RequestParam(value = "id")int id){
        Rdatatype rdatatype=new Rdatatype();
        User u=userService.getUserTeacherById(id);
        rdatatype.setData(u);
        return  rdatatype;
    }

    @PreAuthorize("hasAuthority('USER_GETTEACHER')")
    @ResponseBody
    @GetMapping("/teacher/getallteacher")
    public Rdatatype getTeacher(@RequestParam(value = "start",defaultValue = "0")int start,
                                @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= teacherService.selectAllCount();
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<User> data=userService.getAllUserTeacher(start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }
}
