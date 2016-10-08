package com.yeapoo.statistics.controller.vo.cost;

import com.yeapoo.statistics.constant.CostDetail;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 总消费分布VO
 * Created by hebo on 2016/10/8.
 */
public class CostDiagramVO implements Serializable{

    private static final long serialVersionUID = -5826263610444270981L;
    private CostDetail costDetail;
    /**
     * 消费详情
     */
    private String costDetailStr;
    /**
     * 消费金额
     */
    private BigDecimal totalAmount;

    public CostDetail getCostDetail() {
        return costDetail;
    }

    public void setCostDetail(CostDetail costDetail) {
        this.costDetail = costDetail;
    }

    public String getCostDetailStr() {
        if (StringUtils.isNotBlank(costDetailStr)){
            CostDetail costDetail =  CostDetail.getByCode(costDetailStr);
            if (costDetail!=null)
                return costDetail.getCnName();
        }
        return costDetailStr;
    }

    public void setCostDetailStr(String costDetailStr) {
        this.costDetailStr = costDetailStr;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
