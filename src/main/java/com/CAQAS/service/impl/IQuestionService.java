package com.CAQAS.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.QuestionMapper;
import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.pojo.Question;
import com.CAQAS.service.QuestionService;

@Service
public class IQuestionService implements QuestionService {

	@Resource
	private QuestionMapper questionMapper;
	
	public Map<String, Object> selectQuestionsByUserId(Integer quesUserId, Integer page, 
			Integer pageNum, Integer solved) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectQuestionsByUserId(quesUserId, 
				(page - 1)*pageNum, pageNum, solved));
		return map;
	}

	public int deleteByQuesId(Integer quesId) {
		return questionMapper.deleteByPrimaryKey(quesId);
	}

	public QuestionsResultModel selectByQuesId(Integer quesId) {
		return questionMapper.selectByQuesId(quesId);
	}

	public int updateByPrimaryKeySelective(Question question) {
		return questionMapper.updateByPrimaryKeySelective(question);
	}

}
