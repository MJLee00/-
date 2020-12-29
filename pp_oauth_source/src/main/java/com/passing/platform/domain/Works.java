package com.passing.platform.domain;

import java.util.Date;

public class Works {
    private Integer worksid;

    private Integer userid;

    private String worksname;

    private String vedio;

    private String img;

    private Date publishtime;

    private String workscontent;

    public Integer getWorksid() {
        return worksid;
    }

    public void setWorksid(Integer worksid) {
        this.worksid = worksid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getWorksname() {
        return worksname;
    }

    public void setWorksname(String worksname) {
        this.worksname = worksname == null ? null : worksname.trim();
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio == null ? null : vedio.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getWorkscontent() {
        return workscontent;
    }

    public void setWorkscontent(String workscontent) {
        this.workscontent = workscontent == null ? null : workscontent.trim();
    }
}