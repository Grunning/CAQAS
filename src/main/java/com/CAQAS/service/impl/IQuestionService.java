package com.CAQAS.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.QuestionMapper;
import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.pojo.Question;
import com.CAQAS.service.QuestionService;
import com.CAQAS.util.SimilarityUtil;
import com.xq.algorithm.CosineSimilarAlgorithm;

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
		if (listResult.size() == 0 &&  page == 0) {
			listResult = questionMapper.selectSearchSimilarity();
			for (int i = 0; i < listResult.size(); i ++) {
				double similarity1 = CosineSimilarAlgorithm.cosSimilarityByString(listResult.get(i).getQuesTitle(), searchTitle);
				double similarity2 = SimilarityUtil.similarity(listResult.get(i).getQuesTitle(), searchTitle);
				if (similarity1 <= 0.75 || similarity2 <= 0.40) {
					listResult.remove(i);
					i --;
				} else {
					listResult.get(i).setSimilarity(similarity1);
				}
			}
		}
		
		List<Integer> listQuesIds = new ArrayList<Integer>();
		for (QuestionsResultModel qrm : listResult) {
			listQuesIds.add(qrm.getQuesId());
		}
		if (listQuesIds.size() != 0) {
			questionMapper.updateBatchQuestionsSearchNum(listQuesIds);
		}
		
		/*Collections.sort(listResult, new Comparator<QuestionsResultModel>() {
               public int compare(QuestionsResultModel arg0, QuestionsResultModel arg1) {
                   Double similary0 = arg0.getSimilarity();
                   Double similary1 = arg1.getSimilarity();
                  if(similary0 > similary1)
                      return 1;
                  else
                      return -1;
               }
           });*/
		
		//如果询问问题没有对应答案就将该问题填充到问题库
		if (listResult.size() == 0 && page == 0) {
			Question question = new Question();
			question.setQuesTitle(searchTitle);
			question.setQuesCreateTime(new Date());
			questionMapper.insertSelective(question);
		}
		
		map.put("result", listResult);
		return map;
	}

	public Map<String, Object> selectAllQuestionsByUserId(Integer quesUserId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", questionMapper.selectAllQuestionsByUserId(quesUserId));
		return map;
	}

	public int insertSelective(Question question) {
		return questionMapper.insertSelective(question);
	}

}
