package com.CAQAS.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.pojo.User;
import com.CAQAS.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 根据用户Id查询所有问题.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectQuestionsByUserId")
	public Map<String, Object> selectQuestionsByUserId(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer quesUserId = user.getUserId();
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Integer solved = Integer.parseInt(request.getParameter("solved"));
		return questionService.selectQuestionsByUserId(quesUserId, page, pageNum, solved);
	}
	
	/**
	 * 根据问题Id删除相应问题.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/deleteByQuesId")
	public Integer deleteByQuesId(HttpServletRequest request) {
		Integer quesId = Integer.parseInt(request.getParameter("quesId"));
		return questionService.deleteByQuesId(quesId);
	}
	
	@ResponseBody
	@RequestMapping("/selectByQuesId")
	public QuestionsResultModel selectByQuesId(HttpServletRequest request) {
		Integer quesId = Integer.parseInt(request.getParameter("quesId"));
		return questionService.selectByQuesId(quesId);
	}

}
