package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.constant.UserRole;
import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.base.Pagination;
import com.yeapoo.statistics.controller.param.UserEntityRequest;
import com.yeapoo.statistics.controller.vo.cost.UserListVO;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.mapper.UserEntityMapper;
import com.yeapoo.statistics.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserEntityMapper mapper;

	@Autowired
	private Md5PasswordEncoder passwordEncoder;


    @Override
    public BaseListResponse<UserListVO> queryUserList(BaseQueryRequest<UserEntityRequest> queryRequest, UserEntity loginUser) {
        BaseListResponse<UserListVO> baseListResponse = new BaseListResponse<UserListVO>();
        try {
            if (loginUser == null){
                baseListResponse.setErrorMessage("登录用户为空，请重新登录");
                return baseListResponse;
            }
            if (!UserRole.ADMIN.name().equalsIgnoreCase(loginUser.getUsername())){
                UserEntityRequest userEntityRequest = queryRequest.getCondition();
                userEntityRequest.setRecommendFirstId(loginUser.getId());
                userEntityRequest.setRecommendSecondId(loginUser.getId());
            }
            List<UserEntity> userEntities = mapper.queryUserList(queryRequest);
            List<UserListVO> userListVOs = new ArrayList<UserListVO>();
            if (CollectionUtils.isNotEmpty(userEntities)){
                for (UserEntity userEntity : userEntities) {
                    userListVOs.add(new UserListVO(userEntity));
                }
            }
            Integer count = mapper.countUser(queryRequest);
            Pagination pagination = queryRequest.getPagination();
            pagination.countRecords(count);
            pagination.setRecords(count);
            baseListResponse.setPagination(pagination);
            baseListResponse.setResults(userListVOs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseListResponse;
    }

    public UserEntity getUserEntityByUserName(String username) {
		return mapper.getUserEntityByUserName(username);
	}

	public BaseSingleResponse addUser(UserEntity user) {
        BaseSingleResponse baseSingleResponse = new BaseSingleResponse();
        try {
            UserEntity recommendUser = this.getUserEntityByUserName(user.getRecommendUsername());
            if (!"admin".equals(user.getUsername())) {
                if (recommendUser==null){
                    baseSingleResponse.setErrorMessage("推荐人不存在！");
                    return baseSingleResponse;
                }else {
                    user.setRecommendFirstId(recommendUser.getId());
                    user.setRecommendFirstName(recommendUser.getUsername());
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
            mapper.insertSelective(user);
        } catch (Exception e) {
            baseSingleResponse.setErrorMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseSingleResponse;
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
