package com.CAQAS.dao;

import com.CAQAS.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}