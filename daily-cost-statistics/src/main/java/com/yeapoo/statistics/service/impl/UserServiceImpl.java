package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.mapper.UserEntityMapper;
import com.yeapoo.statistics.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserEntityMapper mapper;

	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	public UserEntity getUserEntityByUserName(String username) {
		return mapper.getUserEntityByUserName(username);
	}

	public boolean addUser(UserEntity user) {
		user.setStatus(ConstantEnum.USER_STATUS_0.getCodeByte());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		if (StringUtils.isNotBlank(user.getPassword())){
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		}
		return mapper.insert(user)==1;
	}

	public boolean updateUser(UserEntity user) {
		user.setUpdateTime(new Date());
		if (StringUtils.isNotBlank(user.getPassword())){
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		}
		return mapper.updateByPrimaryKeySelective(user)==1;
	}

	public boolean isPasswordValid(String rawPass, String un) {
		boolean result = false;
		if (StringUtils.isNotBlank(rawPass) && StringUtils.isNotBlank(rawPass)){
			UserEntity user = getUserEntityByUserName(un);
			if (user!=null && passwordEncoder.isPasswordValid(user.getPassword(), rawPass, user.getUsername())){
				result = true;
			}
		}
		return result;
	}

}
