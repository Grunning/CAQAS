package com.CAQAS.service;

import java.util.Map;

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
	
	/**
	 * 查询所有用户.
	 * @param page 当前页
	 * @param pageNum 每页条数
	 * @return 结果
	 */
	public Map<String, Object> selectAllUsers(Integer page, Integer pageNum);
	
	/**
	 * 添加.
	 * @param user user对象
	 * @return 结果
	 */
	public int insertSelective(User user);
	
	/**
	 * 修改.
	 * @param user user对象
	 * @return 结果
	 */
	public int updateByPrimaryKeySelective(User user);
	
	/**
	 * 删除.
	 * @param userId userId用户Id
	 * @return 结果
	 */
	public int deleteByPrimaryKey(Integer userId);
}
