package com.passing.platform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.passing.platform.dao.WorksMapper;
import com.passing.platform.domain.Works;
import com.passing.platform.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WorksServiceImpl implements WorksService {
    @Autowired(required = false)
    private WorksMapper worksMapper;

    @Override
    public int createWorks(Works works) {
        worksMapper.insert(works);
        if(!works.getImg().equals("/image/works/default.jpg")){
            works.setImg("/image/works/"+works.getWorksid()+"-"+works.getUserid()+works.getImg());
        }
        if(!works.getVedio().equals("/vedio/works/default.mp4")){
            works.setVedio("/vedio/works/"+works.getWorksid()+"-"+works.getUserid()+works.getVedio());
        }
        worksMapper.updateByPrimaryKey(works);
        return works.getWorksid();
    }

    @Override
    public boolean changeWorks(JSONObject jsonObject) {
        Works works1 = worksMapper.selectByPrimaryKey(jsonObject.getIntValue("worksId"));
        Set<String> keySet = jsonObject.keySet();
        for(String s:keySet){
            switch (s){
                case "worksname":{
                    works1.setWorksname(jsonObject.getString(s));
                    break;
                }
                case "workscontent":{
                    works1.setWorkscontent(jsonObject.getString(s));
                    break;

                }
                case  "image":{
                    works1.setImg("/image/works/"+jsonObject.getString(s));
                    break;
                }
                case  "vedio":{
                    works1.setVedio("/vedio/works/"+jsonObject.getString(s));
                    break;
                }
            }
        }

        return worksMapper.updateByPrimaryKeySelective(works1)>0?true:false;
    }

    @Override
    public String returnFilepath(String type, int worksId) {
        Works works = worksMapper.selectByPrimaryKey(worksId);
        String iPath="D://imgbs//works//";
        String vPath="D://vedbs//works//";
        if(type.equals("image")){
            return iPath+works.getImg().substring(works.getImg().lastIndexOf("/")+1);
        }else if(type.equals("vedio")){
            return vPath+works.getVedio().substring(works.getVedio().lastIndexOf("/")+1);
        }
        return null;
    }

    @Override
    public Works selectWorks(int worksId) {
        return worksMapper.selectByPrimaryKey(worksId);
    }

    @Override
    public List<Works> selectWorkByTeacherid(int id, int start, int pagesize) {
        return worksMapper.selectWorkByTeacherid(id,start,pagesize);
    }

    @Override
    public int selectCountByTeacherid(int id) {
        return worksMapper.selectCountByTeacherid(id);
    }
}
