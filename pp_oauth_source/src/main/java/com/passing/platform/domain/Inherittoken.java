package com.passing.platform.domain;

import java.util.Date;

public class Inherittoken {
    private Integer inherittokenid;

    private Integer userid;

    private String inherittokenname;

    private String inherittokenimg;

    private Date creattime;

    private String inherittokencontent;

    public Integer getInherittokenid() {
        return inherittokenid;
    }

    public void setInherittokenid(Integer inherittokenid) {
        this.inherittokenid = inherittokenid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getInherittokenname() {
        return inherittokenname;
    }

    public void setInherittokenname(String inherittokenname) {
        this.inherittokenname = inherittokenname == null ? null : inherittokenname.trim();
    }

    public String getInherittokenimg() {
        return inherittokenimg;
    }

    public void setInherittokenimg(String inherittokenimg) {
        this.inherittokenimg = inherittokenimg == null ? null : inherittokenimg.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getInherittokencontent() {
        return inherittokencontent;
    }

    public void setInherittokencontent(String inherittokencontent) {
        this.inherittokencontent = inherittokencontent == null ? null : inherittokencontent.trim();
    }
}