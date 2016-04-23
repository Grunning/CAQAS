package com.CAQAS.dao;

import com.CAQAS.pojo.Answer;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKeyWithBLOBs(Answer record);

    int updateByPrimaryKey(Answer record);
}