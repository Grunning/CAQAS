package com.CAQAS.service;

import java.util.Map;

import com.CAQAS.pojo.Category;

public interface CategoryService {
	/**
	 * 查询所有类别.
	 * @return 结果
	 */
	Map<String, Object> selectAllCategories();
	
	/**
	 * 添加.
	 * @param category category对象
	 * @return 结果
	 */
	int insertSelective(Category category);
	
	/**
	 * 修改.
	 * @param category category对象
	 * @return 结果
	 */
	int updateByPrimaryKeySelective(Category category);
	
}
