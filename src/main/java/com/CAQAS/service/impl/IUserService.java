package com.CAQAS.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CAQAS.dao.UserMapper;
import com.CAQAS.pojo.User;
import com.CAQAS.service.UserService;

@Service
public class IUserService implements UserService {

	@Resource
	private UserMapper userMapper;
	
	public User selectUser(Integer userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

	public User selectByUserName(String userName) {
		return this.userMapper.selectByUserName(userName);
	}

	public Map<String, Object> selectAllUsers(Integer page, Integer pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", userMapper.selectAllUsers(page, pageNum));
		return map;
	}

	public int insertSelective(User user) {
		return userMapper.insertSelective(user);
	}

	public int updateByPrimaryKeySelective(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public int deleteByPrimaryKey(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	public Map<String, Object> selectUserByDepId(Integer userDepId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", userMapper.selectUserByDepId(userDepId));
		return map;
	}

}
