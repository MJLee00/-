package com.passing.platform.domain;

public class Teacher {
    private Integer uid;

    private String businessname;

    private String businesslogo;

    private Integer mainitem;

    private String commitment;

    private String imageone;

    private String imagetwo;

    private String businessplan;

    private Integer sequence;

    private Integer courseid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname == null ? null : businessname.trim();
    }

    public String getBusinesslogo() {
        return businesslogo;
    }

    public void setBusinesslogo(String businesslogo) {
        this.businesslogo = businesslogo == null ? null : businesslogo.trim();
    }

    public Integer getMainitem() {
        return mainitem;
    }

    public void setMainitem(Integer mainitem) {
        this.mainitem = mainitem;
    }

    public String getCommitment() {
        return commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment == null ? null : commitment.trim();
    }

    public String getImageone() {
        return imageone;
    }

    public void setImageone(String imageone) {
        this.imageone = imageone == null ? null : imageone.trim();
    }

    public String getImagetwo() {
        return imagetwo;
    }

    public void setImagetwo(String imagetwo) {
        this.imagetwo = imagetwo == null ? null : imagetwo.trim();
    }

    public String getBusinessplan() {
        return businessplan;
    }

    public void setBusinessplan(String businessplan) {
        this.businessplan = businessplan == null ? null : businessplan.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }
}