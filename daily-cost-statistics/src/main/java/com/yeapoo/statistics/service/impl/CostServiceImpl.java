package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.mapper.CostEntityMapper;
import com.yeapoo.statistics.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * Created by hebo on 2016/8/1.
 */
@Service("costService")
public class CostServiceImpl  implements CostService{

    @Autowired
    private CostEntityMapper costEntityMapper;

    public CostEntity addOrUpdateCost(CostEntity costEntity) {
        if (costEntity!=null){
            costEntity.setCreateTime(new Date());
            costEntity.setUpdateTime(new Date());
            if (costEntity.getCostTime()==null){
                costEntity.setCostTime(new Date());
            }
            if (costEntity.getId()!=null){
                costEntityMapper.updateByPrimaryKeySelective(costEntity);
            }else {
                costEntityMapper.insert(costEntity);
            }
        }
        return costEntity;
    }
}
