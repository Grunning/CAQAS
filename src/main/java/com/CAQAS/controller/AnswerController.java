package com.CAQAS.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.dao.QuestionMapper;
import com.CAQAS.pojo.Answer;
import com.CAQAS.pojo.Question;
import com.CAQAS.pojo.User;
import com.CAQAS.service.AnswerService;
import com.CAQAS.service.QuestionService;

@Controller
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * 修改或回答问题的答案.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/insertAnswer")
	public int insertAnswer(HttpServletRequest request) {
		Integer quesId = Integer.parseInt(request.getParameter("quesId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Answer answer = new Answer();
		answer.setAnswTitle(title);
		answer.setAnswContent(content);
		answer.setAnswTime(new Date());
		int result = answerService.insertAnswer(answer);
		Question question = new Question();
		question.setQuesId(quesId);
		question.setQuesAnswId(answer.getAnswId());
		question.setQuesCreateTime(new Date());
		questionService.updateByPrimaryKeySelective(question);
		return result;
	}
	
	/**
	 * 录入问题及答案.
	 * @param request request对象
	 * @param session session对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/addAnswerAndQuestion")
	public int addAnswerAndQuestion(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) session.getAttribute("user");
		Answer answer = new Answer();
		answer.setAnswTitle(title);
		answer.setAnswContent(content);
		answer.setAnswTime(new Date());
		int result = answerService.insertAnswer(answer);
		Question question = new Question();
		question.setQuesTitle(title);
		question.setQuesAnswId(answer.getAnswId());
		question.setQuesCreateTime(new Date());
		question.setQuesUserId(user.getUserId());
		questionMapper.insertSelective(question);
		return result;
	}
}
