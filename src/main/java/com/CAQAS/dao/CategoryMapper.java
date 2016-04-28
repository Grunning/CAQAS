package com.CAQAS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.CAQAS.pojo.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cateId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cateId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category> selectAllCategories(@Param("page")Integer page, @Param("pageNum")Integer pageNum);
    
    int deleteBatchCategory(List<String> list);
}