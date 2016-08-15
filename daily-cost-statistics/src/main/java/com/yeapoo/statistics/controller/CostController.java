package com.yeapoo.statistics.controller;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.constant.ConstantEnum;
import com.yeapoo.statistics.constant.CostDetail;
import com.yeapoo.statistics.constant.CostType;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.base.BaseSingleResponse;
import com.yeapoo.statistics.controller.param.CostListParam;
import com.yeapoo.statistics.controller.vo.cost.AmountMouthVO;
import com.yeapoo.statistics.controller.vo.cost.CostListVO;
import com.yeapoo.statistics.controller.vo.cost.CostStatisticsVO;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.service.CostService;
import com.yeapoo.statistics.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 消费controller
 * Created by hebo on 2016/8/1.
 */
@Controller
@RequestMapping("/cost")
public class CostController {

    Logger logger = LoggerFactory.getLogger(CostController.class);

    @Autowired
    private CostService costService;

    @RequestMapping("/toCostList")
    public String toCostList(Model model){

        model.addAttribute("statusEnum", Status.values());
        model.addAttribute("costTypeEnum", CostType.values());
        model.addAttribute("costDetailEnum", CostDetail.values());

        return "cost/cost_list";
    }

    @ResponseBody
    @RequestMapping("/ajaxQueryCostList")
    public BaseListResponse<CostListVO> ajaxQueryCostList(HttpServletRequest request, CostListParam costListParam){
        BaseListResponse<CostListVO> baseListResponse = new BaseListResponse<CostListVO>();
        logger.info("ajaxQueryCostList start params = {} ", costListParam);
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user==null){
                baseListResponse.setCode(CodeEnum.LOGIN_ERROR);
                baseListResponse.setMessage(CodeEnum.LOGIN_ERROR.getValueStr());
                return baseListResponse;
            }
            if (!ConstantEnum.SUPER_ADMIN.getValueStr().equals(user.getJob())){
                costListParam.setCreateBy(user.getUsername());
            }
            BaseQueryRequest<CostListParam> queryRequest =
                    new BaseQueryRequest<CostListParam>(costListParam.getPagination(), costListParam);
            baseListResponse = costService.queryCostList(queryRequest);
        } catch (Exception e) {
            baseListResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseListResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseListResponse;
    }

    @ResponseBody
    @RequestMapping("/ajaxAddOrUpdateCost")
    public BaseSingleResponse ajaxAddOrUpdateCost(HttpServletRequest request, CostListParam costListParam){
        BaseSingleResponse baseSingleResponse = new BaseSingleResponse();
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user==null){
                baseSingleResponse.setCode(CodeEnum.LOGIN_ERROR);
                baseSingleResponse.setMessage(CodeEnum.LOGIN_ERROR.getValueStr());
                return baseSingleResponse;
            }
//            if (costListParam.getCostAmount()==null || costListParam.get)
            if (StringUtils.isNotBlank(costListParam.getCostTimeStr()))
                costListParam.setCostTime(DateUtil.string2Date(costListParam.getCostTimeStr(), DateUtil.FORMAT_DATE));
            baseSingleResponse = costService.addOrUpdateCost(costListParam.getCostEntity(),user);
            baseSingleResponse.setMessage("操作成功！");
        } catch (Exception e) {
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseSingleResponse;
    }

    @ResponseBody
    @RequestMapping("/modifyCostStatus")
    public BaseSingleResponse modifyCostStatus(HttpServletRequest request, CostListParam costListParam) {
        BaseSingleResponse baseSingleResponse = new BaseSingleResponse();

        try {
            logger.info("modifyCostStatus paramsId = {}",costListParam.getId());
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user==null){
                baseSingleResponse.setCode(CodeEnum.LOGIN_ERROR);
                baseSingleResponse.setMessage(CodeEnum.LOGIN_ERROR.getValueStr());
                return baseSingleResponse;
            }
            if (costListParam.getId()==null || costListParam.getStatus()==null){
                baseSingleResponse.setCode(CodeEnum.PARAMS_ERROR);
                baseSingleResponse.setMessage(CodeEnum.PARAMS_ERROR.getValueStr());
                return baseSingleResponse;
            }
            baseSingleResponse = costService.modifyCostStatus(costListParam.getCostEntity(),user);
        } catch (Exception e) {
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }

        return  baseSingleResponse;
    }

    /**
     * 跳转消费统计页
     * @param model
     * @param type
     * @return
     */
    @RequestMapping("/toCostStatistics")
    public String toCostStatistics(Model model, String type){
        try {
            logger.info(" this is log4j log toCostStatisticsPage start type={}", type);
            model.addAttribute("nav", ConstantEnum.STATISTICS.getCodeInt());
            model.addAttribute("type", type);
            model.addAttribute("statusEnum", Status.values());
            model.addAttribute("costTypeEnum", CostType.values());
            model.addAttribute("costDetailEnum", CostDetail.values());
            logger.info(" this is log4j log toCostStatisticsPage end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cost/cost_statistics";
    }

    /**
     * 个人消费总额统计
     * @param request
     * @param costListParam
     * @return
     */
    @ResponseBody
    @RequestMapping("/countCostAmount")
    public BaseSingleResponse<CostStatisticsVO<AmountMouthVO>> ajaxCountCostAmount(HttpServletRequest request, CostListParam costListParam) {
        BaseSingleResponse<CostStatisticsVO<AmountMouthVO>> baseSingleResponse = new BaseSingleResponse<CostStatisticsVO<AmountMouthVO>>();

        try {
            logger.info("ajax Count Cost Amount params = {}",costListParam);
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user==null){
                baseSingleResponse.setCode(CodeEnum.LOGIN_ERROR);
                baseSingleResponse.setMessage(CodeEnum.LOGIN_ERROR.getValueStr());
                return baseSingleResponse;
            }
            if (!ConstantEnum.SUPER_ADMIN.getValueStr().equals(user.getJob())){
                costListParam.setCreateBy(user.getUsername());
            }
            BaseQueryRequest<CostListParam> queryRequest = new BaseQueryRequest<CostListParam>(costListParam);
            baseSingleResponse = costService.countCostAmount(queryRequest);
        } catch (Exception e) {
            baseSingleResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseSingleResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }

        return  baseSingleResponse;
    }

}
