package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.base.Pagination;
import com.yeapoo.statistics.controller.vo.CostListVO;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.mapper.CostEntityMapper;
import com.yeapoo.statistics.service.CostService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by hebo on 2016/8/1.
 */
@Service("costService")
public class CostServiceImpl  implements CostService{

    Logger logger = LoggerFactory.getLogger(CostServiceImpl.class);

    @Autowired
    private CostEntityMapper costEntityMapper;

    public BaseSingleResponse<CostEntity> addOrUpdateCost(CostEntity costEntity, UserEntity user) {
        BaseSingleResponse<CostEntity> baseSingleResponse = new BaseSingleResponse<CostEntity>();
        try {
            if (costEntity!=null){
                costEntity.setUpdateTime(new Date());
                costEntity.setUpdateBy(user.getUsername());
                if (costEntity.getCostTime()==null){
                    costEntity.setCostTime(new Date());
                }
                if (costEntity.getId()!=null){
                    costEntityMapper.updateByPrimaryKeySelective(costEntity);
                }else {
                    costEntity.setCreateTime(new Date());
                    costEntity.setCreateBy(user.getUsername());
                    costEntityMapper.insert(costEntity);
                }
                baseSingleResponse.setResult(costEntity);
            }
        } catch (Exception e) {
            logger.error("addOrUpdateCost error msg : ");
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseSingleResponse;
    }

    @Override
    public BaseSingleResponse modifyCostStatus(CostEntity costEntity,UserEntity user) {
        BaseSingleResponse<CostEntity> baseSingleResponse = new BaseSingleResponse<CostEntity>();
        try {
            if (costEntity!=null){
                costEntity.setUpdateTime(new Date());
                costEntity.setUpdateBy(user.getUsername());
                costEntityMapper.updateByPrimaryKeySelective(costEntity);
            }
        } catch (Exception e) {
            logger.error("modifyCostStatus error msg : ");
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseSingleResponse;
    }

    @Override
    public BaseListResponse<CostListVO> queryCostList(BaseQueryRequest<CostEntity> queryRequest) {
        BaseListResponse<CostListVO> baseListResponse = new BaseListResponse<CostListVO>();
        try {
            List<CostListVO> reVos = new ArrayList<CostListVO>();
            List<CostEntity> costEntities = costEntityMapper.queryCostList(queryRequest);
            if (CollectionUtils.isNotEmpty(costEntities)){
                for (CostEntity costEntity : costEntities) {
                    CostListVO vo = new CostListVO(costEntity);
                    reVos.add(vo);
                }
            }
            Integer count = costEntityMapper.countCost(queryRequest);
            Pagination pagination = queryRequest.getPagination();
            pagination.countRecords(count);
            pagination.setRecords(count);
            baseListResponse.setPagination(pagination);
            baseListResponse.setResults(reVos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return baseListResponse;
    }
}
