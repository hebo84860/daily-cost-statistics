package com.yeapoo.statistics.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Created by yea on 2016/3/25.
 */
public class StatisticsVO implements Serializable {
    /**
     * 月份
     */
    private String mouth;
    /**
     * 在终端销售比例
     */
    private Double scalePlatform;
    /**
     * 每月售完项目数
     */
    private Integer countProject;
    /**
     * 项目上线时间
     */
    private Date createTime;
    /**
     * 项目金额
     */
    private BigDecimal amountProject;

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public Integer getCountProject() {
        return countProject;
    }

    public Double getScalePlatform() {
        return scalePlatform;
    }

    public void setScalePlatform(Double scalePlatform) {
        this.scalePlatform = scalePlatform;
    }

    public void setCountProject(Integer countProject) {
        this.countProject = countProject;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmountProject() {
        return amountProject;
    }

    public void setAmountProject(BigDecimal amountProject) {
        this.amountProject = amountProject;
    }

    @Override
    public String toString() {
        return "StatisticsVO{" +
                "mouth='" + mouth + '\'' +
                ", countProject=" + countProject +
                ", createTime=" + createTime +
                ", amountProject=" + amountProject +
                ", scalePlatform=" + scalePlatform +
                '}';
    }
}
