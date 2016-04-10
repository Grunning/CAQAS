package com.CAQAS.pojo;

import java.util.Date;

public class Question {
    private Integer qId;

    private String title;

    private Integer searchNum;

    private Integer qAId;

    private Date time;

    private Date answerTime;

    private Integer qDepId;

    private Integer qCategoryId;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(Integer searchNum) {
        this.searchNum = searchNum;
    }

    public Integer getqAId() {
        return qAId;
    }

    public void setqAId(Integer qAId) {
        this.qAId = qAId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getqDepId() {
        return qDepId;
    }

    public void setqDepId(Integer qDepId) {
        this.qDepId = qDepId;
    }

    public Integer getqCategoryId() {
        return qCategoryId;
    }

    public void setqCategoryId(Integer qCategoryId) {
        this.qCategoryId = qCategoryId;
    }
}