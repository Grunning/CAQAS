package com.CAQAS.pojo;

import java.util.Date;

public class Question {
    private Integer quesId;

    private String quesTitle;

    private Integer searchNum;

    private Integer quesAnswId;

    private Date quesTime;

    private Date quesAnswerTime;

    public Integer getQuesId() {
        return quesId;
    }

    public void setQuesId(Integer quesId) {
        this.quesId = quesId;
    }

    public String getQuesTitle() {
        return quesTitle;
    }

    public void setQuesTitle(String quesTitle) {
        this.quesTitle = quesTitle == null ? null : quesTitle.trim();
    }

    public Integer getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(Integer searchNum) {
        this.searchNum = searchNum;
    }

    public Integer getQuesAnswId() {
        return quesAnswId;
    }

    public void setQuesAnswId(Integer quesAnswId) {
        this.quesAnswId = quesAnswId;
    }

    public Date getQuesTime() {
        return quesTime;
    }

    public void setQuesTime(Date quesTime) {
        this.quesTime = quesTime;
    }

    public Date getQuesAnswerTime() {
        return quesAnswerTime;
    }

    public void setQuesAnswerTime(Date quesAnswerTime) {
        this.quesAnswerTime = quesAnswerTime;
    }
}