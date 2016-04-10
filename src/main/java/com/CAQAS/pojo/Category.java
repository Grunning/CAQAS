package com.CAQAS.pojo;

public class Category {
    private Integer cId;

    private String category;

    private Integer typeDepId;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getTypeDepId() {
        return typeDepId;
    }

    public void setTypeDepId(Integer typeDepId) {
        this.typeDepId = typeDepId;
    }
}