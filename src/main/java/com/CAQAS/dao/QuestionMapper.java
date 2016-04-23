package com.CAQAS.dao;

import com.CAQAS.pojo.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer quesId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer quesId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}