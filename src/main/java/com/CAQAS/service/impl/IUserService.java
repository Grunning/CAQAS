package com.CAQAS.service.impl;

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

}
