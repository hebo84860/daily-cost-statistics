package com.yeapoo.statistics.mapper;

import com.yeapoo.statistics.entity.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    UserEntity getUserEntityByUserName(String username);
}