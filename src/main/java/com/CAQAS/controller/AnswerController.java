package com.CAQAS.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Answer;
import com.CAQAS.pojo.Question;
import com.CAQAS.service.AnswerService;
import com.CAQAS.service.QuestionService;

@Controller
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
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
}
