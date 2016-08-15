package com.yeapoo.statistics.controller.vo.cost;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * Created by hebo on 2016/8/15.
 */
public class AmountMouthVO implements Serializable {
    private static final long serialVersionUID = -1204545346050151766L;

    private String mouth;

    private BigDecimal mouthCost;

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public BigDecimal getMouthCost() {
        return mouthCost;
    }

    public void setMouthCost(BigDecimal mouthCost) {
        this.mouthCost = mouthCost;
    }

}
