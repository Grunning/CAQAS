package com.CAQAS.dao;

import org.apache.ibatis.annotations.Param;

import com.CAQAS.pojo.Feedback;

public interface FeedbackMapper {
	int insertFeedbackInfo(Feedback feedback);
	
	Feedback selectFeedbackByIpAndQuesId(@Param("feedIp")String feedIp, @Param("feedQuesId")Integer feedQuesId);
}
