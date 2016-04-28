package com.CAQAS.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.CategoryMapper;
import com.CAQAS.pojo.Category;
import com.CAQAS.service.CategoryService;

@Service
public class ICategoryService implements CategoryService {

	@Resource
	private CategoryMapper categoryMapper;
	
	public Map<String, Object> selectAllCategories(Integer page, Integer pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", categoryMapper.selectAllCategories((page - 1)*pageNum, pageNum));
		return map;
	}

	public int insertSelective(Category category) {
		return categoryMapper.insertSelective(category);
	}

	public int updateByPrimaryKeySelective(Category category) {
		return categoryMapper.updateByPrimaryKeySelective(category);
	}

	public int deleteBatchCategory(String cateIds) {
		String[] array = cateIds.split(",");
		List<String> list = new ArrayList<String>();
		for (String s : array) {
			list.add(s);
		}
		return categoryMapper.deleteBatchCategory(list);
	}

}
