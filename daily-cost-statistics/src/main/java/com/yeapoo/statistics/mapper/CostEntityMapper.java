package com.yeapoo.statistics.mapper;


import com.yeapoo.statistics.entity.CostEntity;

public interface CostEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostEntity record);

    int insertSelective(CostEntity record);

    CostEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CostEntity record);

    int updateByPrimaryKey(CostEntity record);
}