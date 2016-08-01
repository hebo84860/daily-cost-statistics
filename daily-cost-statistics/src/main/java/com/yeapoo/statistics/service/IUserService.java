package com.yeapoo.statistics.service;

import com.yeapoo.statistics.entity.UserEntity;

public interface IUserService {
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	UserEntity getUserEntityByUserName(String username);
	/**
	 * 新增会员用户
	 * @param user
	 */
	boolean addUser(UserEntity user);
	/**
	 * 新增会员用户
	 * @param user
	 */
	boolean updateUser(UserEntity user);

	/**
	 * 验证密码
	 * @param rawPass 登录密码
	 * @param un 盐值
	 * @return
	 */
	boolean isPasswordValid(String rawPass, String un) ;

}
