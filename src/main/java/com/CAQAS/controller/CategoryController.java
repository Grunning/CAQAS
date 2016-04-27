package com.CAQAS.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Category;
import com.CAQAS.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 查询所有类别.
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAllCategories")
	public Map<String, Object> selectAllCategories(HttpServletRequest request) {
		return categoryService.selectAllCategories();
	}
	
	/**
	 * 添加.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/insertCategory")
	public Integer insertCategory(HttpServletRequest request) {
		String cateName = request.getParameter("cateName");
		Category category = new Category();
		category.setCateName(cateName);
		return categoryService.insertSelective(category);
	}
	
	/**
	 * 修改.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/updateCategory")
	public Integer updateCategory(HttpServletRequest request) {
		Integer cateId = Integer.parseInt(request.getParameter("cateId"));
		String cateName = request.getParameter("cateName");
		Category category = new Category();
		category.setCateId(cateId);
		category.setCateName(cateName);
		return categoryService.updateByPrimaryKeySelective(category);
	}
	
}
