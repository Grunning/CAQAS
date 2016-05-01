package com.CAQAS.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Category;
import com.CAQAS.pojo.User;
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
	public Map<String, Object> selectAllCategories(HttpServletRequest request, HttpSession session) {
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		User user = (User) session.getAttribute("user");
		Integer role = user.getUserRole();
		Integer userId = user.getUserId();
		return categoryService.selectAllCategories(page, pageNum, role, userId);
	}
	
	/**
	 * 查询下拉框所有问题分类.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectAllCates")
	public Map<String, Object> selectAllCates(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Integer cateUserId = user.getUserId();
		return categoryService.selectAllCates(cateUserId);
	}
	
	/**
	 * 根据类别名字查询.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectByCateName")
	public Category selectByCateName(HttpServletRequest request) {
		String cateName = request.getParameter("cateName");
		return categoryService.selectByCateName(cateName);
	}
	
	/**
	 * 添加.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/insertCategory")
	public Integer insertCategory(HttpServletRequest request, HttpSession session) {
		String cateName = request.getParameter("cateName");
		User user = (User) session.getAttribute("user");
		Integer cateUserId = user.getUserId();
		Category category = new Category();
		category.setCateName(cateName);
		category.setCateUserId(cateUserId);
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
	
	/**
	 * 批量删除.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/deleteBatchCategory")
	public Integer deleteBatchCategory(HttpServletRequest request) {
		String cateIds = request.getParameter("cateIds");
		return categoryService.deleteBatchCategory(cateIds);
	}
	
}
