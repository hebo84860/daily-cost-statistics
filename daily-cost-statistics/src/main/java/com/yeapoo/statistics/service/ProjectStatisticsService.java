package com.yeapoo.statistics.service;

import com.yeapoo.statistics.controller.vo.PlatformScaleVO;
import com.yeapoo.statistics.controller.vo.StatisticsVO;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by hebo on 2016/3/24.
 */
public interface ProjectStatisticsService {

    /**
     * 第一个项目上线时间
     */
    StatisticsVO getFirstOnlineTime();

    /**
     * 以月为单位横轴展示每月上项目数
     */
    Map<String, Object> countSaledProject(Map<String,Object> paramsMap);

    /**
     * 项目累积总金额（已经放款之后的状态），以月为单位横轴展示每月累积金额。
     */
    Map<String, Object> countSaleProjectAmount(Map<String,Object> paramsMap);

    /**
     * 以不同金额递增为横轴展示每种金额的最快销售时间差（分）。
     */
    List<StatisticsVO> getProjectSaledTimeDiff();
    /**
     * 会员数量，以月为单位横轴展示每月会员增加数量。
     */
    List<StatisticsVO> countProjectMember(Map<String,Object> paramsMap);
    /**
     * 以月为单位横轴展示每月购买的客户数
     */
    Map<String, Object> countBuyeredProjectMember(Map<String,Object> paramsMap);

    /**
     * 以月为单位横轴展示每月购买的客户数
     */
    Map<String, Object> countPlatformScale(Map<String, Object> paramsMap);

    /**
     * 获取各省市销售额
     */
    Map<String, Object> countSalesMap(Map<String, Object> paramsMap);
}
