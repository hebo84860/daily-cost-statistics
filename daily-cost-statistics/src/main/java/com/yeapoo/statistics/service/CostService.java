package com.yeapoo.statistics.service;

import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.vo.CostListVO;
import com.yeapoo.statistics.entity.CostEntity;

/**
 *
 * Created by hebo on 2016/8/1.
 */
public interface CostService {

    BaseSingleResponse<CostEntity> addOrUpdateCost(CostEntity costEntity);

    BaseListResponse<CostListVO> queryCostList(BaseQueryRequest<CostEntity> queryRequest);

}
