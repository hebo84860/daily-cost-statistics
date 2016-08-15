package com.yeapoo.statistics.mapper;


import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.param.CostListParam;
import com.yeapoo.statistics.controller.vo.cost.AmountMouthVO;
import com.yeapoo.statistics.entity.CostEntity;

import java.math.BigDecimal;
import java.util.List;

public interface CostEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostEntity record);

    CostEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CostEntity record);

    int countCost(BaseQueryRequest<CostListParam> queryRequest );
    List<CostEntity> queryCostList(BaseQueryRequest<CostListParam> queryRequest );

    BigDecimal totalCostAmount(BaseQueryRequest<CostListParam> queryRequest);


    List<AmountMouthVO> countCostAmountMouth(BaseQueryRequest<CostListParam> queryRequest);
}