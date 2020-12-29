package com.passing.platform.service.impl;

import com.passing.platform.dao.MessageMapper;
import com.passing.platform.domain.Message;
import com.passing.platform.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public boolean createMessage(Message message) {
        message.setSendtime(new Date());
        message.setIfread(0);
        return messageMapper.insert(message)>0?true:false;
    }

    @Override
    public List<Message> selectBysenderid(int senderid) {
        List<Message> resultList = new ArrayList();
        List<Message> aList = messageMapper.selectAll();
        for(Message message:aList){
            if((int)message.getSenderid()==senderid){
                resultList.add(message);
            }
        }
        return resultList;
    }

    @Override
    public List<Message> selectByrecid(int recid) {
        List<Message> resultList = new ArrayList();
        List<Message> aList = messageMapper.selectAll();
        for(Message message:aList){
            if((int)message.getReceiverid()==recid){
                resultList.add(message);
            }
        }
        return resultList;
    }

    @Override
    public boolean changeStage(int messageId,boolean ifread) {
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if(ifread){
            message.setIfread(1);
        }else {
            message.setIfread(0);
        }
        return messageMapper.updateByPrimaryKey(message)>0?true:false;
    }
}
