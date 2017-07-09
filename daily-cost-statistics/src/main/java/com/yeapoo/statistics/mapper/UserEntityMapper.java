package com.yeapoo.statistics.mapper;

import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.param.UserEntityRequest;
import com.yeapoo.statistics.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    UserEntity getUserEntityByUserName(String username);

    List<UserEntity> queryUserList(BaseQueryRequest<UserEntityRequest> queryRequest);

    Integer countUser(BaseQueryRequest<UserEntityRequest> queryRequest);

    void updateCheckUserByStatus(UserEntity user);
}