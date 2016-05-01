package com.CAQAS.service;

import java.util.Map;

import com.CAQAS.pojo.Category;

public interface CategoryService {
	/**
	 * 查询所有类别.
	 * @return 结果
	 */
	Map<String, Object> selectAllCategories(Integer page, Integer pageNum, Integer role, Integer userId);
	
	/**
	 * 问题类别下拉框.
	 * @return 结果
	 */
	Map<String, Object> selectAllCates(Integer cateUserId);
	
	/**
	 * 根据类别名查询.
	 * @param cateName cateName类别名称
	 * @return 结果
	 */
	Category selectByCateName(String cateName);
	
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
	
	/**
	 * 批量删除.
	 * @param cateIds cateIds类别Ids
	 * @return 结果
	 */
	int deleteBatchCategory(String cateIds);
	
}
