package com.yeapoo.statistics.controller;

import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.controller.vo.StatisticsVO;
import com.yeapoo.statistics.service.ProjectStatisticsService;
import com.yeapoo.statistics.util.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目统计
 * Created by hebo on 2016/3/24.
 */
@Controller
@RequestMapping("/ps")
public class ProjectStatisticsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectStatisticsService projectStatisticsService;

    @RequestMapping("/toStatistics")
    public String toStatisticsPage(Model model, String type){
        try {
            logger.info(" this is log4j log toStatisticsPage start type={}", type);
            model.addAttribute("nav", ConstantEnum.STATISTICS.getCodeInt());
            StatisticsVO vo = projectStatisticsService.getFirstOnlineTime();
            if (vo!=null)
                model.addAttribute("createTime", vo.getCreateTime());
            model.addAttribute("type", type);
            logger.info(" this is log4j log toStatisticsPage end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "statistics";
    }

    /**
     * 以月为单位横轴展示每月上项目数。
     * @return
     */
    @RequestMapping("/countSalesProject")
    @ResponseBody
    public String countSalesProject(String paramsJson){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            logger.info(" countSalesProject start paramsJson={}", paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            result = projectStatisticsService.countSaledProject(couvertParamsMap(paramsMap));
            logger.info(" countSalesProject end result = {}",JsonUtil.getJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(result);
    }

    /**
     * 以月为单位横轴展示每月累积金额。
     * @return
     */
    @RequestMapping("/salesProjectAmount")
    @ResponseBody
    public String salesProjectAmount(String paramsJson){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            logger.info(" salesProjectAmount start...paramsJson={}",paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            map = projectStatisticsService.countSaleProjectAmount(couvertParamsMap(paramsMap));
            logger.info(" salesProjectAmount end result = {}",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(map);
    }

    /**
     * 各金额最快售完时间（分钟）
     * @return
     */
    @RequestMapping("/salesTimeAmount")
    @ResponseBody
    public String salesTimeAmount(){
        List<StatisticsVO> salesProject = null;
        try {
            logger.info(" salesTimeAmount start...");
            salesProject = projectStatisticsService.getProjectSaledTimeDiff();
            logger.info(" salesTimeAmount end result = {}",salesProject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(salesProject);
    }

    /**
     * 月增总会员
     * @return
     */
    @RequestMapping("/addMemberNumber")
    @ResponseBody
    public String addMemberNumber(String paramsJson){
        List<StatisticsVO> salesProject;
        List<StatisticsVO> result = new ArrayList<StatisticsVO>();
        try {
            logger.info(" addMemberNumber start...parmasJson={}",paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            salesProject = projectStatisticsService.countProjectMember(couvertParamsMap(paramsMap));
            if (CollectionUtils.isNotEmpty(salesProject)) {
                for (int i=0; i<salesProject.size(); i++){
                    StatisticsVO vo = salesProject.get(i);
                    if (i!=0) {
                        vo.setCountProject(vo.getCountProject()+result.get(i-1).getCountProject());
                    }
                    result.add(vo);
                }
            }
            logger.info(" addMemberNumber end result = {}",salesProject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(result);
    }
    /**
     * 月有购买记录会员
     * @return
     */
    @RequestMapping("/buyersMemberNumber")
    @ResponseBody
    public String buyersMemberNumber(String paramsJson){
        Map<String, Object> map = null;
        try {
            logger.info(" buyersMemberNumber start...paramsJson={}", paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            map = projectStatisticsService.countBuyeredProjectMember(couvertParamsMap(paramsMap));
            logger.info(" buyersMemberNumber end result = {}",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(map);
    }

    /**
     * 终端比例
     * @return
     */
    @RequestMapping("/countScalePlatform")
    @ResponseBody
    public String countScalePlatform(String paramsJson){
        Map<String, Object> map = null;
        try {
            logger.info(" countScalePlatform start paramsJson = {}", paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            map = projectStatisticsService.countPlatformScale(couvertParamsMap(paramsMap));
            logger.info(" countScalePlatform end result = {}",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(map);
    }

    /**
     * 销售分布统计图
     * @return
     */
    @RequestMapping("/countSalesMap")
    @ResponseBody
    public String countSalesMap(String paramsJson){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            logger.info(" countSalesMap start paramsJson = {}", paramsJson);
            Map<String, Object> paramsMap = JsonUtil.getMapFromJson(paramsJson);
            map = projectStatisticsService.countSalesMap(paramsMap);
            logger.info(" countSalesMap end result = {}",map);
            map.put("code",0);
        } catch (Exception e) {
            map.put("code", 1);
            map.put("msg", "系统错误");
            e.printStackTrace();
        }
        return JsonUtil.getJSONString(map);
    }

    private Map<String, Object> couvertParamsMap(Map<String, Object> paramsMap) {
        if (paramsMap.containsKey("endTime")){
            String endTime = paramsMap.get("endTime").toString();
            Integer year = Integer.valueOf(endTime.substring(0,4));
            Integer mouth = Integer.valueOf(endTime.substring(5,7));
            if (mouth==12){
                mouth = 1;
                year += 1;
            }else {
                mouth += 1;
            }
            if(mouth>9)
            	paramsMap.put("endTime", year.toString()+"-"+mouth.toString());
            else
            	paramsMap.put("endTime", year.toString()+"-0"+mouth.toString());
            	
        }
        return paramsMap;
    }

}
