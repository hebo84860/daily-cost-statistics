package com.yeapoo.statistics.service;

import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.param.CostListParam;
import com.yeapoo.statistics.controller.vo.cost.CostDiagramVO;
import com.yeapoo.statistics.controller.vo.cost.CostListVO;
import com.yeapoo.statistics.controller.vo.cost.CostStatisticsVO;
import com.yeapoo.statistics.controller.vo.cost.AmountMouthVO;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.entity.UserEntity;

/**
 *
 * Created by hebo on 2016/8/1.
 */
public interface CostService {

    BaseSingleResponse<CostEntity> addOrUpdateCost(CostEntity costEntity, UserEntity user);

    BaseSingleResponse modifyCostStatus(CostEntity costEntity,UserEntity user);

    BaseListResponse<CostListVO> queryCostList(BaseQueryRequest<CostListParam> queryRequest);

    BaseSingleResponse<CostStatisticsVO<AmountMouthVO>> countCostAmount(BaseQueryRequest<CostListParam> queryRequest);

    BaseListResponse<CostDiagramVO> countCostDiagram(BaseQueryRequest<CostListParam> queryRequest);
}
