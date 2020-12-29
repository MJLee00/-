package com.passing.platform.domain;

public class Topics {
    private Integer id;

    private Integer testingid;

    private String title;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestingid() {
        return testingid;
    }

    public void setTestingid(Integer testingid) {
        this.testingid = testingid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}