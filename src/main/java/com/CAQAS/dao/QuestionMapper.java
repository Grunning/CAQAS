package com.CAQAS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CAQAS.model.QuestionsResultModel;
import com.CAQAS.model.TagCloudCategoryResultModel;
import com.CAQAS.pojo.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer quesId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer quesId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    List<QuestionsResultModel> selectQuestionsByUserId(@Param("quesUserId") Integer quesUserId, @Param("page")Integer page, 
    		@Param("pageNum")Integer pageNum, @Param("solved")Integer solved, @Param("role")Integer role);
    
    List<QuestionsResultModel> selectQuestionsByAdmin(@Param("page")Integer page, @Param("pageNum")Integer pageNum, @Param("role")Integer role);
    
    List<QuestionsResultModel> selectQuestionsBySearchNum(@Param("quesCateId")Integer quesCateId);
    
    List<QuestionsResultModel> selectVagueQuestionsSearch(@Param("searchTitle")String searchTitle, @Param("page")Integer page, @Param("pageNum")Integer pageNum);
    
    List<TagCloudCategoryResultModel> selectCategoryToTagCloud();
    
    int updateBatchQuestionsSearchNum(List<Integer> list);
    
    QuestionsResultModel selectByQuesId(Integer quesId);
}