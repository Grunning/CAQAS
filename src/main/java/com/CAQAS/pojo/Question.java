package com.CAQAS.pojo;

import java.util.Date;

public class Question {
    private Integer quesId;

    private String quesTitle;

    private Integer searchNum;

    private Integer quesAnswId;

    private Date quesCreateTime;
    
    private Integer quesIsuseNum;
    
    private Integer quesNouseNum;
    
    private Integer quesUserId;
    
    private Integer quesCateId;

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

	public Date getQuesCreateTime() {
		return quesCreateTime;
	}

	public void setQuesCreateTime(Date quesCreateTime) {
		this.quesCreateTime = quesCreateTime;
	}

	public Integer getQuesIsuseNum() {
		return quesIsuseNum;
	}

	public void setQuesIsuseNum(Integer quesIsuseNum) {
		this.quesIsuseNum = quesIsuseNum;
	}

	public Integer getQuesNouseNum() {
		return quesNouseNum;
	}

	public void setQuesNouseNum(Integer quesNouseNum) {
		this.quesNouseNum = quesNouseNum;
	}

	public Integer getQuesUserId() {
		return quesUserId;
	}

	public void setQuesUserId(Integer quesUserId) {
		this.quesUserId = quesUserId;
	}

	public Integer getQuesCateId() {
		return quesCateId;
	}

	public void setQuesCateId(Integer quesCateId) {
		this.quesCateId = quesCateId;
	}

}