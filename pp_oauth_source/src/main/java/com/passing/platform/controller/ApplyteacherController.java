package com.passing.platform.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.passing.platform.domain.Applyteacher;
import com.passing.platform.domain.Message;
import com.passing.platform.domain.Recruit;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.ApplyteacherService;
import com.passing.platform.service.impl.MessageServiceImpl;
import com.passing.platform.service.impl.RecruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplyteacherController {

    @Autowired(required = false)
    private ApplyteacherService applyteacherService;

    @Autowired(required = false)
    private MessageServiceImpl messageService;
    @Autowired(required = false)
    private RecruitServiceImpl recruitService;

    @ResponseBody
    @PostMapping("/applyteacher")
    public Rdatatype insertApplyteacher(@RequestBody String applyteacher){
        Rdatatype rdatatype=new Rdatatype();
        JSONObject record=JSON.parseObject(applyteacher);
        JSONObject value=JSON.parseObject(record.get("applyteacher").toString());
        Integer recruitid=Integer.parseInt(String.valueOf(value.get("recruitid")));
        Applyteacher applyteacher1=new Applyteacher();
        applyteacher1.setAdvangtage(String.valueOf(value.get("advantage")));
        applyteacher1.setSelfintro(String.valueOf(value.get("intro")));
        applyteacher1.setReason(String.valueOf(value.get("reason")));
        applyteacher1.setPrize(String.valueOf(value.get("prize")));
        applyteacher1.setEmail(String.valueOf(value.get("email")));
        applyteacher1.setPhone(String.valueOf(value.get("phone")));
        applyteacher1.setName(String.valueOf(value.get("name")));
        applyteacher1.setApplyid(Integer.parseInt(String.valueOf(value.get("applyid"))));
        applyteacher1.setRecruitid(recruitid);
        applyteacher1.setIsconfirmed(false);
        Integer applyid= applyteacherService.insert(applyteacher1);

        //send message to teacher
        Recruit recruit=recruitService.selectByPrimaryKey(recruitid);
        Message message=new Message();
        message.setContent("拜师申请");
        message.setSenderid(Integer.parseInt(String.valueOf(value.get("applyid"))));
        message.setReceiverid(recruit.getTeacherid());
        message.setType(0);
        message.setIfread(0);
        message.setTypeid(applyteacher1.getId());

        messageService.createMessage(message);
        rdatatype.setMessage("success");
        return  rdatatype;
    }

    @ResponseBody
    @GetMapping("/applyteacher")
    public Rdatatype getApplyDetail(@RequestParam(value = "id") Integer id){
        Rdatatype rdatatype=new Rdatatype();

        Applyteacher applyteacher= applyteacherService.selectByPrimaryKey(id);
        rdatatype.setData(applyteacher);
        return rdatatype;
    }

}
