package com.yeapoo.statistics.mapper;


import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.entity.CostEntity;

import java.util.List;

public interface CostEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostEntity record);

    CostEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CostEntity record);

    int countCost(BaseQueryRequest<CostEntity> queryRequest );
    List<CostEntity> queryCostList(BaseQueryRequest<CostEntity> queryRequest );

}