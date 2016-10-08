package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.base.Pagination;
import com.yeapoo.statistics.controller.param.CostListParam;
import com.yeapoo.statistics.controller.vo.cost.CostDiagramVO;
import com.yeapoo.statistics.controller.vo.cost.CostListVO;
import com.yeapoo.statistics.controller.vo.cost.CostStatisticsVO;
import com.yeapoo.statistics.controller.vo.cost.AmountMouthVO;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.mapper.CostEntityMapper;
import com.yeapoo.statistics.service.CostService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public BaseListResponse<CostListVO> queryCostList(BaseQueryRequest<CostListParam> queryRequest) {
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

    /**
     *  消费总金额
     * @param queryRequest
     * @return
     */
    @Override
    public BaseSingleResponse<CostStatisticsVO<AmountMouthVO>> countCostAmount(BaseQueryRequest<CostListParam> queryRequest) {

        BaseSingleResponse<CostStatisticsVO<AmountMouthVO>> baseSingleResponse = new BaseSingleResponse<CostStatisticsVO<AmountMouthVO>>();
        try {
            CostStatisticsVO<AmountMouthVO> costStatisticsVO = new CostStatisticsVO<AmountMouthVO>();
            List<AmountMouthVO> statisticsVOs = costEntityMapper.countCostAmountMouth(queryRequest);
            BigDecimal totalCount  = costEntityMapper.totalCostAmount(queryRequest);
            if (CollectionUtils.isNotEmpty(statisticsVOs)){
                statisticsVOs = convertDateStr(statisticsVOs);
            }
            costStatisticsVO.setCostTotal(totalCount);
            costStatisticsVO.setStaticticsVOs(statisticsVOs);
            baseSingleResponse.setResult(costStatisticsVO);
        } catch (Exception e) {
            logger.error("totalCostAmount error msg : ");
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseSingleResponse;
    }

    @Override
    public BaseListResponse<CostDiagramVO> countCostDiagram(BaseQueryRequest<CostListParam> queryRequest) {
        BaseListResponse<CostDiagramVO> listResponse = new BaseListResponse<CostDiagramVO>();
        try {
            List<CostDiagramVO> list = costEntityMapper.countCostDiagram(queryRequest);
            listResponse.setResults(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResponse;
    }

    private List<AmountMouthVO> convertDateStr(List<AmountMouthVO> statisticsVOs) {
        List<AmountMouthVO> reList = new ArrayList<AmountMouthVO>();
        for (AmountMouthVO vo : statisticsVOs){
            if (StringUtils.isNotBlank(vo.getMouth()) && vo.getMouth().length()>4){
                vo.setMouth(vo.getMouth().substring(0, 4) + "-" + vo.getMouth().substring(4));
            }
            reList.add(vo);
        }
        return reList;
    }

}
