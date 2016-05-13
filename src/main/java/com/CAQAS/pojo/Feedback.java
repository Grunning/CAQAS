package com.CAQAS.pojo;

import java.util.Date;

public class Feedback {
	private Integer feedId;
	
	private String feedIp;
	
	private Date feedTime;
	
	private Integer feedIsUseful;
	
	private Integer feedQuesId;

	public Integer getFeedId() {
		return feedId;
	}

	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}

	public String getFeedIp() {
		return feedIp;
	}

	public void setFeedIp(String feedIp) {
		this.feedIp = feedIp;
	}

	public Date getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(Date feedTime) {
		this.feedTime = feedTime;
	}

	public Integer getFeedIsUseful() {
		return feedIsUseful;
	}

	public void setFeedIsUseful(Integer feedIsUseful) {
		this.feedIsUseful = feedIsUseful;
	}

	public Integer getFeedQuesId() {
		return feedQuesId;
	}

	public void setFeedQuesId(Integer feedQuesId) {
		this.feedQuesId = feedQuesId;
	}
	
}
