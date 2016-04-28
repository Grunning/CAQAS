package com.CAQAS.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.DepartmentMapper;
import com.CAQAS.pojo.Department;
import com.CAQAS.service.DepartmentService;

@Service
public class IDepartmentService implements DepartmentService {
	
	@Resource
	private DepartmentMapper departmentMapper;
	
	public Map<String, Object> selectAllDepartments(Integer page, Integer pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", departmentMapper.selectAllDepartments(page, pageNum));
		return map;
	}

	public Integer insertSelective(Department department) {
		return departmentMapper.insertSelective(department);
	}

	public Integer updateByPrimaryKeySelective(Department department) {
		return departmentMapper.updateByPrimaryKeySelective(department);
	}

	public int deleteByPrimaryKey(Integer depId) {
		return departmentMapper.deleteByPrimaryKey(depId);
	}

	public int deleteBatchDep(String depIds) {
		String[] array = depIds.split(",");
		List<String> list = new ArrayList<String>();
		for (String s : array) {
			list.add(s);
		}
		return departmentMapper.deleteBatchDep(list);
	}

	public Department selectByDepName(String depName) {
		return departmentMapper.selectByDepName(depName);
	}

}
