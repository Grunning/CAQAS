package com.CAQAS.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			Integer pageNum, Integer solved, Integer role) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectQuestionsByUserId(quesUserId, 
				(page - 1)*pageNum, pageNum, solved, role));
		return map;
	}
	
	public Map<String, Object> selectQuestionsByAdmin(Integer page, Integer pageNum, Integer role) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectQuestionsByAdmin((page - 1)*pageNum, pageNum, role));
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

	public Map<String, Object> selectQuestionsBySearchNum(Integer quesCateId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectQuestionsBySearchNum(quesCateId));
		return map;
	}

	public Map<String, Object> selectCategoryToTagCloud() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectCategoryToTagCloud());
		return map;
	}

	public Map<String, Object> selectVagueQuestionsSearch(String searchTitle, Integer page, Integer pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<QuestionsResultModel> listResult = questionMapper.selectVagueQuestionsSearch(searchTitle, page, pageNum);
		List<Integer> listQuesIds = new ArrayList<Integer>();
		for (QuestionsResultModel qrm : listResult) {
			listQuesIds.add(qrm.getQuesId());
		}
		if (listQuesIds.size() != 0) {
			questionMapper.updateBatchQuestionsSearchNum(listQuesIds);
		}
		map.put("result", listResult);
		return map;
	}

}
