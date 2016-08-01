package com.yeapoo.statistics.mapper;

import com.yeapoo.statistics.controller.vo.AreaVO;
import com.yeapoo.statistics.controller.vo.PlatformScaleVO;
import com.yeapoo.statistics.controller.vo.StatisticsVO;
import com.yeapoo.statistics.entity.ProjectEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProjectEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectEntity record);

    int insertSelective(ProjectEntity record);

    ProjectEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectEntity record);

    int updateByPrimaryKey(ProjectEntity record);

    StatisticsVO getFirstOnlineTime();

    List<StatisticsVO> countSaledProject(Map<String,Object> paramsMap);

    List<StatisticsVO> countSaleProjectAmount(Map<String,Object> paramsMap);

    List<StatisticsVO> getProjectSaledTimeDiff();

    List<StatisticsVO> countProjectMember(Map<String,Object> paramsMap);

    List<StatisticsVO> countBuyeredProjectMember(Map<String,Object> paramsMap);

    List<PlatformScaleVO> countPlatformScale(Map<String,Object> map);

    int totalProject();

    BigDecimal totalAmount();

    int totalBuyerCount();

    int totalBuyerMember();

    List<AreaVO> countProvinceSalesMap(Map<String, Object> paramsMap);

    List<AreaVO> countCitySalesMap(Map<String, Object> paramsMap);
}