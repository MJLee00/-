package com.passing.platform.controller;

import com.passing.platform.domain.Teachertouser;
import com.passing.platform.domain.User;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.TeachertouserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TeachertouserController {

    @Autowired
    private TeachertouserServiceImpl teachertouserService;

    @ResponseBody
    @GetMapping("/getStudentsByTeacher")
    public Rdatatype getStudentsByteacherid(@RequestParam("id")int id, @RequestParam(value = "start",defaultValue = "0")int start,
                                            @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= teachertouserService.getStudentCountByTeacherId(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<User> data=teachertouserService.getStudentsByTeacherId(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }
    @ResponseBody
    @GetMapping("/getTeachersByStudentid")
    public Rdatatype getTeachersByStudentid(@RequestParam("id")int id, @RequestParam(value = "start",defaultValue = "0")int start,
                                            @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= teachertouserService.getTeacherCountByStudentId(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Teachertouser>  data=teachertouserService.getTeacherByStudentId(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }

}
