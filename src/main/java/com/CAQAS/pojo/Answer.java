package com.CAQAS.pojo;

import java.util.Date;

public class Answer {
    private Integer aId;

    private String title;

    private String keyWords;

    private Integer aCategoryId;

    private Date time;

    private String content;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public Integer getaCategoryId() {
        return aCategoryId;
    }

    public void setaCategoryId(Integer aCategoryId) {
        this.aCategoryId = aCategoryId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}