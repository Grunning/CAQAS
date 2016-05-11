package com.CAQAS.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.AnswerMapper;
import com.CAQAS.pojo.Answer;
import com.CAQAS.service.AnswerService;

@Service
public class IAnswerService implements AnswerService {

	@Resource
	private AnswerMapper answerMapper;
	
	public int insertAnswer(Answer answer) {
		return answerMapper.insertSelective(answer);
	}

	public int updateAnswer(Answer answer) {
		return answerMapper.updateByPrimaryKeySelective(answer);
	}

}
