package com.passing.platform.domain;

public class Applyteacher {
    private Integer id;

    private Integer applyid;

    private String selfintro;

    private String reason;

    private String advangtage;

    private String prize;

    private String name;

    private String phone;

    private String email;

    private Boolean isconfirmed;

    private Integer recruitid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public String getSelfintro() {
        return selfintro;
    }

    public void setSelfintro(String selfintro) {
        this.selfintro = selfintro == null ? null : selfintro.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getAdvangtage() {
        return advangtage;
    }

    public void setAdvangtage(String advangtage) {
        this.advangtage = advangtage == null ? null : advangtage.trim();
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize == null ? null : prize.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsconfirmed() {
        return isconfirmed;
    }

    public void setIsconfirmed(Boolean isconfirmed) {
        this.isconfirmed = isconfirmed;
    }

    public Integer getRecruitid() {
        return recruitid;
    }

    public void setRecruitid(Integer recruitid) {
        this.recruitid = recruitid;
    }
}