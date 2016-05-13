package com.CAQAS.service;

import com.CAQAS.pojo.Feedback;

public interface FeedbackService {
	/**
	 * 查询当前访客的问题操作.
	 * @param feedIp 访客Ip
	 * @param feedQuesId 问题Id
	 * @return 结果
	 */
	Feedback selectFeedbackByIpAndQuesId(String feedIp, Integer feedQuesId);
}
