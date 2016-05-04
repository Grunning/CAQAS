package com.CAQAS.model;

public class TagCloudCategoryResultModel {
	private Integer cateId;
	private String cateName;
	private long questionNum;
	
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
		this.cateName = cateName;
	}
	public long getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(long questionNum) {
		this.questionNum = questionNum;
	}
	
}
