package com.passing.platform.domain;

import java.util.Date;
import java.util.List;

public class Teachertouser {
    private Integer idteachertouser;

    private Integer teacherid;

    private Integer studentid;

    private Date starttime;

    private List<User> studentsList;
    public List<User> getStudentsList(){return  studentsList;}



    private List<User> teacherList;
    public List<User> getTeacherList(){return  teacherList;}

    public Integer getIdteachertouser() {
        return idteachertouser;
    }

    public void setIdteachertouser(Integer idteachertouser) {
        this.idteachertouser = idteachertouser;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
}