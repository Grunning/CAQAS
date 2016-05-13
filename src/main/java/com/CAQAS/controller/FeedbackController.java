package com.CAQAS.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Feedback;
import com.CAQAS.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	/**
	 * 查询当前访客对问题的反馈.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectFeedbackByIpAndQuesId")
	public Feedback selectFeedbackByIpAndQuesId(HttpServletRequest request){
		String feedIp = request.getRemoteAddr();
		Integer quesId = Integer.parseInt(request.getParameter("feedQuesId"));
		return feedbackService.selectFeedbackByIpAndQuesId(feedIp, quesId);
	}
}
