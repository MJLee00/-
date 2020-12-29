package com.passing.platform.controller;

import com.passing.platform.domain.Message;
import com.passing.platform.returndatatype.Rdatatype;
import com.passing.platform.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;


    @ResponseBody
    @GetMapping("/getBysenderid/{senderid}")
    public Rdatatype getBysenderid(@PathVariable int senderid){
        List<Message> resultList = new ArrayList();
        try{
            resultList = messageService.selectBysenderid(senderid);
        }catch (Exception e){
            e.printStackTrace();
            return Rdatatype.onError(e.getMessage());
        }
        return Rdatatype.onSuccess(resultList);
    }

    @ResponseBody
    @GetMapping("/getByrecid/{recid}")
    public Rdatatype getByrecid(@PathVariable int recid){


        List<Message> resultList = new ArrayList();
        try{
            resultList = messageService.selectByrecid(recid);

        }catch (Exception e){
            e.printStackTrace();
            return Rdatatype.onError(e.getMessage());
        }
        return Rdatatype.onSuccess(resultList);
    }


    @ResponseBody
    @GetMapping("/isread/{mid}")
    public Rdatatype changeStage(@PathVariable int mid){
        String msg="";
        try{
            if(messageService.changeStage(mid,true)){
                msg ="修改成功";
            }else {
                return Rdatatype.onError("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return  Rdatatype.onError(e.getMessage());
        }
        return Rdatatype.onSuccess(msg);
    }


}
