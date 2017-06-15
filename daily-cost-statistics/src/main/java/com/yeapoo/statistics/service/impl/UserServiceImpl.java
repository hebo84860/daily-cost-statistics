package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.constant.UserRole;
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
		UserEntity recommendUser = this.getUserEntityByUserName(user.getRecommendUsername());
		if (!"admin".equals(user.getUsername())) {
			if (recommendUser==null){
                return false;
            }else {
                user.setRecommendFirstId(recommendUser.getId());
                user.setRecommendFirstName(recommendUser.getRecommendFirstName());
                user.setRecommendSecondId(recommendUser.getRecommendFirstId());
                user.setRecommendSecondName(recommendUser.getRecommendFirstName());
				user.setBelongSalesmanId(recommendUser.getBelongSalesmanId());
				user.setBelongFirstDistributionId(recommendUser.getBelongFirstDistributionId());
				if (UserRole.ADMIN.equals(recommendUser.getUserRole())){
					user.setUserRole(UserRole.FIRST_DISTRIBUTION);
				}else if (UserRole.FIRST_DISTRIBUTION.equals(recommendUser.getUserRole())){
					user.setUserRole(UserRole.SECOND_DISTRIBUTION);
                }else if (UserRole.SECOND_DISTRIBUTION.equals(recommendUser.getUserRole())){
                    user.setUserRole(UserRole.THIRD_DISTRIBUTION);
					user.setBelongFirstDistributionId(user.getId());
                }else if (UserRole.THIRD_DISTRIBUTION.equals(recommendUser.getUserRole())){
                    user.setUserRole(UserRole.THIRD_DISTRIBUTION);
					user.setBelongFirstDistributionId(user.getBelongFirstDistributionId());
					user.setBelongSecondDistribution(user.getBelongSecondDistribution());
                }else {
                    user.setUserRole(UserRole.ADMIN);
                }
            }
		}else {
			user.setUserRole(UserRole.ADMIN);
		}
		user.setStatus(Status.CHECK_PENDING);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		if (StringUtils.isNotBlank(user.getPassword())){
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		}
		return mapper.insertSelective(user)==1;
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
