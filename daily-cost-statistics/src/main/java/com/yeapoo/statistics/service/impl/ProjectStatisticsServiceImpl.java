package com.yeapoo.statistics.service.impl;

import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.controller.vo.AreaVO;
import com.yeapoo.statistics.controller.vo.PlatformScaleVO;
import com.yeapoo.statistics.controller.vo.StatisticsVO;
import com.yeapoo.statistics.mapper.ProjectEntityMapper;
import com.yeapoo.statistics.service.ProjectStatisticsService;
import com.yeapoo.statistics.util.IDcardUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by hebo on 2016/3/24.
 */
@Service("projectStatisticsService")
public class ProjectStatisticsServiceImpl implements ProjectStatisticsService{

    Logger logger = LoggerFactory.getLogger(ProjectStatisticsServiceImpl.class);

    @Autowired
    ProjectEntityMapper projectMapper;

    public StatisticsVO getFirstOnlineTime() {
        return projectMapper.getFirstOnlineTime();
    }

    public Map<String, Object> countSaledProject(Map<String,Object> paramsMap) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            List<StatisticsVO> projects = convertDate(projectMapper.countSaledProject(paramsMap));
            int count = projectMapper.totalProject();
            reMap.put("projects", projects);
            reMap.put("count", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reMap;
    }

    public Map<String, Object> countSaleProjectAmount(Map<String,Object> paramsMap) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            reMap.put("amount", projectMapper.totalAmount());
            reMap.put("projects", convertDate(projectMapper.countSaleProjectAmount(paramsMap)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reMap;
    }

    public List<StatisticsVO> getProjectSaledTimeDiff() {
        return convertDate(projectMapper.getProjectSaledTimeDiff());
    }

    public List<StatisticsVO> countProjectMember(Map<String,Object> paramsMap) {
        return convertDate(projectMapper.countProjectMember(paramsMap));
    }

    public Map<String, Object> countBuyeredProjectMember(Map<String,Object> paramsMap) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        reMap.put("count",projectMapper.totalBuyerMember());
        reMap.put("projects",convertDate(projectMapper.countBuyeredProjectMember(paramsMap)));
        return reMap;
    }

    public Map<String, Object> countPlatformScale(Map<String, Object> paramsMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<PlatformScaleVO> scaleVOs = projectMapper.countPlatformScale(paramsMap);
            List<StatisticsVO> PC = new ArrayList<StatisticsVO>();
            List<StatisticsVO> mobile = new ArrayList<StatisticsVO>();
            if (CollectionUtils.isNotEmpty(scaleVOs)){
                StatisticsVO statisticsVO;
                for (PlatformScaleVO vo : scaleVOs){
                    statisticsVO = new StatisticsVO();
                    statisticsVO.setMouth(vo.getMouth());
                    statisticsVO.setScalePlatform(vo.getScale());
                    if (ConstantEnum.PAYMENT_PLATFORM_0.getCodeStr().equals(vo.getPaymentPlatform())){
                        PC.add(statisticsVO);
                        if (100D==vo.getScale()){
                            statisticsVO = new StatisticsVO();
                            statisticsVO.setMouth(vo.getMouth());
                            statisticsVO.setScalePlatform(0D);
                            mobile.add(statisticsVO);
                        }
                    }
                    if (ConstantEnum.PAYMENT_PLATFORM_1.getCodeStr().equals(vo.getPaymentPlatform())){
                        mobile.add(statisticsVO);
                        if (100D==vo.getScale()){
                            statisticsVO = new StatisticsVO();
                            statisticsVO.setMouth(vo.getMouth());
                            statisticsVO.setScalePlatform(0D);
                            PC.add(statisticsVO);
                        }
                    }
                }
            }
            map.put("PC", convertDate(PC));
            map.put("mobile", convertDate(mobile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Object> countSalesMap(Map<String, Object> paramsMap) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        Map<String, Integer> proMap = new HashMap<String, Integer>();
        Map<String, Integer> cityMap = new HashMap<String, Integer>();
        List<AreaVO> pros = projectMapper.countProvinceSalesMap(paramsMap);
        List<AreaVO> cities = projectMapper.countCitySalesMap(paramsMap);
        if (CollectionUtils.isNotEmpty(pros)) {
            for (AreaVO vo : pros) {
                if(StringUtils.isNotBlank(IDcardUtil.proCodes.get(vo.getAreaCode())))
                    proMap.put(IDcardUtil.proCodes.get(vo.getAreaCode()), vo.getCount());
                else
                    logger.info("==== search province by code fail: code = "+vo.getAreaCode());
            }
        }
        if (CollectionUtils.isNotEmpty(cities)){
            for (AreaVO city : cities) {
                if (StringUtils.isNotBlank(IDcardUtil.cityCodes.get(city.getAreaCode())))
                    cityMap.put(IDcardUtil.cityCodes.get(city.getAreaCode()),city.getCount());
                else
                    logger.info("==== search city by code fail: code = "+city.getAreaCode());
            }
        }
        reMap.put("Pro",proMap);
        reMap.put("City",cityMap);
        reMap.put("count", projectMapper.totalBuyerCount());
        return reMap;
    }


    private List<StatisticsVO> convertDate(List<StatisticsVO> statisticsVOs) {
        List<StatisticsVO> reList = new ArrayList<StatisticsVO>();
        for (StatisticsVO vo : statisticsVOs){
            if (StringUtils.isNotBlank(vo.getMouth()) && vo.getMouth().length()>4){
                vo.setMouth(vo.getMouth().substring(0, 4) + "-" + vo.getMouth().substring(4));
            }
            reList.add(vo);
        }
        return reList;
    }

}
