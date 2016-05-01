package com.CAQAS.pojo;

public class Category {
    private Integer cateId;

    private String cateName;
    
    private Integer cateUserId;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

	public Integer getCateUserId() {
		return cateUserId;
	}

	public void setCateUserId(Integer cateUserId) {
		this.cateUserId = cateUserId;
	}
}