package com.yeapoo.statistics.controller.vo.cost;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * Created by hebo on 2016/8/15.
 */
public class CostStatisticsVO<T> implements Serializable {
    private static final long serialVersionUID = -1204545346050151766L;
    private BigDecimal costTotal = BigDecimal.ZERO;
    private List<T> staticticsVOs;

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public List<T> getStaticticsVOs() {
        return staticticsVOs;
    }

    public void setStaticticsVOs(List<T> staticticsVOs) {
        this.staticticsVOs = staticticsVOs;
    }
}
