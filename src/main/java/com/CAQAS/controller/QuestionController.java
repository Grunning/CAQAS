package com.CAQAS.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.pojo.Question;
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
		Integer role = user.getUserRole();
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Integer solved = Integer.parseInt(request.getParameter("solved"));
		return questionService.selectQuestionsByUserId(quesUserId, page, pageNum, solved, role);
	}
	
	/**
	 * 查询超级管理员所有问题.
	 * @param request request对象
	 * @param session session对像
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectQuestionsByAdmin")
	public Map<String, Object> selectQuestionsByAdmin(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer role = user.getUserRole();
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		return questionService.selectQuestionsByAdmin(page, pageNum, role);
	}
	
	/**
	 * 模糊查询.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectVagueQuestionsSearch")
	public Map<String, Object> selectVagueQuestionsSearch(HttpServletRequest request) {
		String searchTitle = request.getParameter("searchTitle");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		System.out.println("主机名：" + request.getRemoteHost());
		System.out.println("User:" + request.getRemoteUser());
		System.out.println("ip地址：" + request.getRemoteAddr());
		System.out.println("端口号：" + request.getRemotePort());
		return questionService.selectVagueQuestionsSearch(searchTitle, (page - 1)*pageNum, pageNum);
	}
	
	/**
	 * answer-search问题常问问题初始化.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectQuestionsBySearchNum")
	public Map<String, Object> selectQuestionsBySearchNum(HttpServletRequest request) {
		Integer quesCateId = null;
		if (request.getParameter("quesCateId") != null) {
			quesCateId = Integer.parseInt(request.getParameter("quesCateId"));
		}
		return questionService.selectQuestionsBySearchNum(quesCateId);
	}
	
	/**
	 * 问题类别对应问题数量.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectCategoryToTagCloud")
	public Map<String, Object> selectCategoryToTagCloud(HttpServletRequest request) {
		return questionService.selectCategoryToTagCloud();
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
	
	/**
	 * 通过问题Id查询.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectByQuesId")
	public QuestionsResultModel selectByQuesId(HttpServletRequest request) {
		Integer quesId = Integer.parseInt(request.getParameter("quesId"));
		return questionService.selectByQuesId(quesId);
	}
	
	/**
	 * 查询当前用户下的所有问题.
	 * @param request request对象
	 * @param session session对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectAllQuestionsByUserId")
	public Map<String, Object> selectAllQuestionsByUserId(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer quesUserId = user.getUserId();
		return questionService.selectAllQuestionsByUserId(quesUserId);
	}
	
	/**
	 * 管理员分配问题给用户回答.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/updateQuestion")
	public Integer updateQuestion(HttpServletRequest request) {
		Question question = new Question();
		Integer quesId = Integer.parseInt(request.getParameter("quesId"));
		if (request.getParameter("quesUserId") != null) {
			Integer quesUserId = Integer.parseInt(request.getParameter("quesUserId"));
			question.setQuesUserId(quesUserId);
		}
		if (request.getParameter("quesCateId") != null) {
			Integer quesCateId = Integer.parseInt(request.getParameter("quesCateId"));
			question.setQuesCateId(quesCateId);
		}
		if (request.getParameter("quesAnswId") != null) {
			Integer quesAnswId = Integer.parseInt(request.getParameter("quesAnswId"));
			question.setQuesAnswId(quesAnswId);
		}
		question.setQuesId(quesId);
		question.setQuesCreateTime(new Date());
		return questionService.updateByPrimaryKeySelective(question);
	}
	
	/**
	 * 添加问题及问题答案指向.
	 * @param request request对象
	 * @param session session对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/insertQuestionAndAnswerSelective")
	public Integer insertQuestionAndAnswerSelective(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer quesUserId = user.getUserId();
		String quesTitle = request.getParameter("quesTitle");
		Integer quesAnswId = Integer.parseInt(request.getParameter("quesAnswId"));
		Question question = new Question();
		question.setQuesTitle(quesTitle);
		question.setQuesUserId(quesUserId);
		question.setQuesCreateTime(new Date());
		question.setQuesAnswId(quesAnswId);
		return questionService.insertSelective(question);
	}

}
