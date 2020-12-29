package com.passing.platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.passing.platform.domain.Works;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.WorksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class WorksController {
    @Autowired
    private WorksServiceImpl worksService;

    @ResponseBody
    @GetMapping("/works")
    public Rdatatype getWorks(@RequestParam(value = "id")int id,@RequestParam(value = "start",defaultValue = "0")int start,
                                     @RequestParam(value = "pagesize",defaultValue = "4")int pagesize){
        Rdatatype  rdatatype=new Rdatatype();
        int total= worksService.selectCountByTeacherid(id);
        int _pagesize=pagesize;
        //若为最后一页则修改pagesize
        if(total-start*_pagesize<pagesize) pagesize=total%pagesize;
        List<Works> data=worksService.selectWorkByTeacherid(id,start*_pagesize,pagesize);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("total",total);
        res.put("data",data);
        rdatatype.setData(res);
        rdatatype.setMessage("success");
        rdatatype.setErrorcode(1);
        return rdatatype;
    }

    @ResponseBody
    @PostMapping("/works")
    public Rdatatype createWorks(@RequestParam MultipartFile image,@RequestParam MultipartFile vedio, HttpServletRequest httpServletRequest){
        Rdatatype rdatatype = new Rdatatype();
        Works works =new Works();
        try{
            if(image.isEmpty()){
                works.setImg("/image/works/default.jpg");
            }else{
                works.setImg(image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".")));
            }
            if(vedio.isEmpty()){
                works.setVedio("/vedio/works/default.mp4");
            }else {
                works.setVedio(vedio.getOriginalFilename().substring(vedio.getOriginalFilename().lastIndexOf(".")));
            }
            works.setPublishtime(new Date());
            works.setUserid(Integer.parseInt(httpServletRequest.getParameter("userid")));
            works.setWorksname(httpServletRequest.getParameter("worksname"));
            works.setWorkscontent(httpServletRequest.getParameter("workscontent"));
            int reinfo = worksService.createWorks(works);
            if(reinfo>0){
                InherittokenController.savaFile(image,reinfo+"-"+Integer.parseInt(httpServletRequest.getParameter("userid")),"D://imgbs//works//");
                InherittokenController.savaFile(vedio,reinfo+"-"+Integer.parseInt(httpServletRequest.getParameter("userid")),"D://vedbs//works//");
                rdatatype.setErrorcode(1);
                rdatatype.setMessage("success");
                rdatatype.setData(reinfo);
            }else {
                rdatatype.setErrorcode(0);
                rdatatype.setMessage("error");
                rdatatype.setData("作品发布失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            rdatatype.setErrorcode(0);
            rdatatype.setMessage("error");
            rdatatype.setData(e.getMessage());
            return  rdatatype;
        }
        return  rdatatype;
    }

    @ResponseBody
    @PutMapping("/works")
    public Rdatatype updateWorks(@RequestParam MultipartFile image,@RequestParam MultipartFile vedio, HttpServletRequest httpServletRequest){
        JSONObject changeInfo = new JSONObject();
        try{
            changeInfo =JSON.parseObject(httpServletRequest.getParameter("changeInfo"));
            if(!changeInfo.getBooleanValue("image")&&!changeInfo.getBooleanValue("vedio")){
                changeInfo.remove("image");
                changeInfo.remove("vedio");
                worksService.changeWorks(changeInfo);
                return Rdatatype.onSuccess("修改成功");
            }
            if(changeInfo.getBooleanValue("image")&&!changeInfo.getBooleanValue("vedio")){
                changeInfo.remove("vedio");
                changeInfo = updateImg(image,changeInfo);
                worksService.changeWorks(changeInfo);
                return Rdatatype.onSuccess("修改成功");

            }
            if(changeInfo.getBooleanValue("vedio")&&!changeInfo.getBooleanValue("image")){
                changeInfo.remove("image");
                changeInfo=updateVedio(vedio,changeInfo);
                worksService.changeWorks(changeInfo);
                return Rdatatype.onSuccess("修改成功");
            }
            if(changeInfo.getBooleanValue("vedio")&&changeInfo.getBooleanValue("image")){
                changeInfo = updateImg(image,changeInfo);
                changeInfo = updateVedio(vedio,changeInfo);
                worksService.changeWorks(changeInfo);
                return Rdatatype.onSuccess("修改成功");

            }
        }catch (Exception e){
            e.printStackTrace();
            return Rdatatype.onError(e.getMessage());
        }


        return Rdatatype.onSuccess("修改成功");
    }

    public static boolean deleteFile(String filePath){
        boolean flag =false;
        File file = new File(filePath);
        if(file.exists() && file.isFile()){
            file.delete();
            flag=true;
        }
        return flag;

    }
    public static String[] cutString(String fileName){
        String[] s = new String[2];
        int index = fileName.lastIndexOf("/");
        s[0] = fileName.substring(0,index+1);
        s[1]=fileName.substring(index+1,fileName.lastIndexOf("."));
        return s;
    }
    public JSONObject updateImg(MultipartFile image,JSONObject changeInfo){
        String[] fileName= cutString(worksService.returnFilepath("image",changeInfo.getIntValue("worksId")));
        if(image.isEmpty()){
            changeInfo.put("image","default.jpg");
            if(!fileName[1].equals("default")) {
                deleteFile(worksService.returnFilepath("image", changeInfo.getIntValue("worksId")));
            }
        }else {
            if(fileName[1].equals("default")){
                fileName[1] = worksService.selectWorks(changeInfo.getIntValue("worksId")).getWorksid()+"-"+
                        worksService.selectWorks(changeInfo.getIntValue("worksId")).getUserid();
            }else {
                deleteFile(worksService.returnFilepath("image",changeInfo.getIntValue("worksId")));
            }

            String s = InherittokenController.savaFile(image,fileName[1],fileName[0]);
            changeInfo.put("image",s);
        }
        return changeInfo;
    }
    public JSONObject updateVedio(MultipartFile vedio ,JSONObject changeInfo){
        String[] fileName= cutString(worksService.returnFilepath("vedio",changeInfo.getIntValue("worksId")));
        if(vedio.isEmpty()){
            changeInfo.put("vedio","default.mp4");
            if(!fileName[1].equals("default")) {
                deleteFile(worksService.returnFilepath("vedio", changeInfo.getIntValue("worksId")));
            }
        }else {
            if(fileName[1].equals("default")){
                fileName[1] = worksService.selectWorks(changeInfo.getIntValue("worksId")).getWorksid()+"-"+
                        worksService.selectWorks(changeInfo.getIntValue("worksId")).getUserid();
            }else {
                deleteFile(worksService.returnFilepath("vedio",changeInfo.getIntValue("worksId")));
            }
            String s = InherittokenController.savaFile(vedio,fileName[1],fileName[0]);
            changeInfo.put("vedio",s);
        }
        return changeInfo;
    }
}
