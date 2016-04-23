package com.CAQAS.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Answer;
import com.CAQAS.service.AnswerService;

@Controller
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@ResponseBody
	@RequestMapping("/insertAnswer")
	public int insertAnswer(HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Answer answer = new Answer();
		answer.setAnswTitle(title);
		answer.setAnswContent(content);
		answer.setAnswTime(new Date());
		return answerService.insertAnswer(answer);
	}
}
