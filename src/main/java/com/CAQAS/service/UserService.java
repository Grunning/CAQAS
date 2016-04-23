package com.CAQAS.service;

import com.CAQAS.pojo.User;

public interface UserService {
	/**
	 * 通过Id查询用户信息
	 * @param userId 用户Id
	 * @return 用户对象信息
	 */
	public User selectUser(Integer userId);
	
	/**
	 * 通过用户名查询用户信息
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	public User selectByUserName(String userName);
}
