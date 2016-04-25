package com.CAQAS.service;

import java.util.Map;

import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.pojo.Question;

public interface QuestionService {
	/**
	 * 通过用户Id查询所有问题.
	 * @param quesUserId 问题对应管理员Id
	 * @param page 页数
	 * @param pageNum 每页条数
	 * @param solved 问题是否解决
	 * @return 结果
	 */
	Map<String, Object> selectQuestionsByUserId(Integer quesUserId, Integer page, Integer pageNum, Integer solved);
	
	/**
	 * 删除问题.
	 * @param quesId 问题Id
	 * @return 结果
	 */
	int deleteByQuesId(Integer quesId);
	
	/**
	 * 根据问题Id查询问题标题和内容.
	 * @param quesId 问题Id
	 * @return 结果
	 */
	QuestionsResultModel selectByQuesId(Integer quesId);
	
	/**
	 * 更新问题属性.
	 * @param question question对象
	 * @return 结果
	 */
	int updateByPrimaryKeySelective(Question question);
}
