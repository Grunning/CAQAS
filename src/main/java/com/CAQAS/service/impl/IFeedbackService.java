package com.CAQAS.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.FeedbackMapper;
import com.CAQAS.pojo.Feedback;
import com.CAQAS.service.FeedbackService;

@Service
public class IFeedbackService implements FeedbackService {

	@Resource
	private FeedbackMapper feedbackMapper;
	
	public Feedback selectFeedbackByIpAndQuesId(String feedIp, Integer feedQuesId) {
		return feedbackMapper.selectFeedbackByIpAndQuesId(feedIp, feedQuesId);
	}

}
