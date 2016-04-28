package com.CAQAS.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CAQAS.pojo.Department;
import com.CAQAS.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 查询所有部门.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/selectAllDepartments")
	public Map<String, Object> selectAllDepartments(HttpServletRequest request) {
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
		return departmentService.selectAllDepartments((page - 1)*pageNum, pageNum);
	}
	
	/**
	 * 添加.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/insertDepartment")
	public Integer insertDepartment(HttpServletRequest request) {
		String depName = request.getParameter("depName");
		Department department = new Department();
		department.setDepName(depName);
		return departmentService.insertSelective(department);
	}
	
	/**
	 * 更新.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/updateDepartment")
	public Integer updateDepartment(HttpServletRequest request) {
		Integer depId = Integer.parseInt(request.getParameter("depId"));
		String depName = request.getParameter("depName");
		Department department = new Department();
		department.setDepId(depId);
		department.setDepName(depName);
		return departmentService.updateByPrimaryKeySelective(department);
	}
	
	/**
	 * 删除.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/deleteDepartment")
	public Integer deleteDepartment(HttpServletRequest request) {
		Integer depId = Integer.parseInt(request.getParameter("depId"));
		return departmentService.deleteByPrimaryKey(depId);
	}
	
	/**
	 * 批量删除.
	 * @param request request对象
	 * @return 结果
	 */
	@ResponseBody
	@RequestMapping("/deleteBatchDep")
	public Integer deleteBatchDep(HttpServletRequest request) {
		String depIds = request.getParameter("depIds");
		return departmentService.deleteBatchDep(depIds);
	}
	
}
