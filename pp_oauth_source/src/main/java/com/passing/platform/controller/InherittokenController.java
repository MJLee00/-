package com.passing.platform.controller;

import com.passing.platform.domain.Inherittoken;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.InherittokenServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/intoken")
public class InherittokenController {
    @Autowired
    private InherittokenServicelmpl inherittokenService;
    @ResponseBody
    @PostMapping("/create")
    public Rdatatype createIntoken(@RequestParam MultipartFile file, HttpServletRequest httpServletRequest){
        Rdatatype rdatatype = new Rdatatype();
        Inherittoken inherittoken = new Inherittoken();
        try {
            if(file.isEmpty()){
                inherittoken.setInherittokenimg("/image/intoken/default.jpg");
            }else {
                inherittoken.setInherittokenimg(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
            }
            inherittoken.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
            inherittoken.setCreattime(new Date());
            inherittoken.setInherittokenname(httpServletRequest.getParameter("intokenname"));
            inherittoken.setInherittokencontent(httpServletRequest.getParameter("intokencontnet"));

            int reinfo = inherittokenService.createInherittoken(inherittoken);
            if(reinfo >0){
                savaFile(file,reinfo+"-"+httpServletRequest.getParameter("userid"),"D://imgbs//intoken//");
                rdatatype.setErrorcode(1);
                rdatatype.setMessage("success");
                rdatatype.setData(reinfo);
            }else {
                rdatatype.setErrorcode(0);
                rdatatype.setMessage("error");
                rdatatype.setData("传承令发布失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            rdatatype.setErrorcode(0);
            rdatatype.setMessage("服务器内部错误");
            rdatatype.setData(e.getMessage());
            return rdatatype;
        }

        return rdatatype;
    }
    public static String savaFile(MultipartFile file,String newFilename,String url){
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filepath = url;
            fileName = newFilename + suffixName;
            File file1 = new File(filepath + fileName);
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdir();
            }
            try {
                file.transferTo(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fileName;
        }
        return null;
    }

    @ResponseBody
    @GetMapping("/getall")
    public Rdatatype getInherittoken(@RequestParam(value = "id")int id,@RequestParam(value = "start",defaultValue = "0")int start,
                              @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= inherittokenService.selectAllCountByUser(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Inherittoken> data=inherittokenService.selectAllInherittoken(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }


}
