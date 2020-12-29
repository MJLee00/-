package com.passing.platform.service.impl;

import com.passing.platform.dao.InherittokenMapper;
import com.passing.platform.domain.Inherittoken;
import com.passing.platform.service.InherittokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InherittokenServicelmpl implements InherittokenService {
    @Autowired
    private InherittokenMapper inherittokenMapper;

    @Override
    public int createInherittoken(Inherittoken inherittoken) {
        inherittokenMapper.insert(inherittoken);
        if(!inherittoken.getInherittokenimg().equals("/image/intoken/default.jpg")){
            inherittoken.setInherittokenimg("/image/intoken/"+inherittoken.getInherittokenid()+"-"+inherittoken.getUserid()+inherittoken.getInherittokenimg());
            inherittokenMapper.updateByPrimaryKey(inherittoken);
        }
        return inherittoken.getInherittokenid();

    }

    @Override
    public List<Inherittoken> selectAllInherittoken(int id, int start, int pagesize) {
        return inherittokenMapper.selectAllInherittoken(id,start,pagesize);
    }

    @Override
    public int selectAllCountByUser(int id) {
        return inherittokenMapper.selectAllCountByUser(id);
    }
}
