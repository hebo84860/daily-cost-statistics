package com.yeapoo.statistics.controller;

import com.yeapoo.statistics.constant.CodeEnum;
import com.yeapoo.statistics.constant.CostDetail;
import com.yeapoo.statistics.constant.CostType;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.controller.base.BaseListResponse;
import com.yeapoo.statistics.controller.base.BaseQueryRequest;
import com.yeapoo.statistics.controller.param.CostListParam;
import com.yeapoo.statistics.controller.vo.CostListVO;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.service.CostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        logger.info("ajaxQueryCostList start params = {} ",costListParam);
        try {
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            if (user==null){
                baseListResponse.setCode(CodeEnum.SYSTEM_ERROR);
                baseListResponse.setMessage(CodeEnum.LOGIN_ERROR.getValueStr());
                return baseListResponse;
            }
            BaseQueryRequest<CostEntity> queryRequest =
                    new BaseQueryRequest<CostEntity>(costListParam.getPagination(), costListParam.getCostEntity());
            baseListResponse = costService.queryCostList(queryRequest);
//            List<CostListVO> listVOs = new ArrayList<CostListVO>();
//            CostListVO resultVo = new CostListVO();
//            CostEntity costEntity = new CostEntity();
//            costEntity.setId(1l);
//            costEntity.setCostTime(new Date());
//            resultVo.setCostEntity(costEntity);
//            listVOs.add(resultVo);
//            baseListResponse.setResults(listVOs);
        } catch (Exception e) {
            baseListResponse.setCode(CodeEnum.SYSTEM_ERROR);
            baseListResponse.setMessage(CodeEnum.SYSTEM_ERROR.getValueStr());
            e.printStackTrace();
        }
        return baseListResponse;
    }

}
