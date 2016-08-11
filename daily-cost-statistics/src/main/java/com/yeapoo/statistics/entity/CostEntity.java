package com.yeapoo.statistics.entity;

import com.yeapoo.statistics.constant.CostDetail;
import com.yeapoo.statistics.constant.CostType;
import com.yeapoo.statistics.constant.Status;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CostEntity implements Serializable{
    private static final long serialVersionUID = 7566263208471907661L;
    private Long id;

    private CostDetail costDetail;

    private BigDecimal costAmount;

    private String costUserId;

    private String costUserName;

    private String costPhone;

    private Date costTime;

    private String description;

    private Status status;

    private CostType costType;

    private String reason;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getCostUserId() {
        return costUserId;
    }

    public void setCostUserId(String costUserId) {
        this.costUserId = costUserId;
    }

    public String getCostUserName() {
        return costUserName;
    }

    public void setCostUserName(String costUserName) {
        this.costUserName = costUserName;
    }

    public Date getCostTime() {
        return costTime;
    }

    public String getCostPhone() {
        return costPhone;
    }

    public void setCostPhone(String costPhone) {
        this.costPhone = costPhone;
    }

    public void setCostTime(Date costTime) {
        this.costTime = costTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public CostDetail getCostDetail() {
        return costDetail;
    }

    public void setCostDetail(CostDetail costDetail) {
        this.costDetail = costDetail;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CostType getCostType() {
        return costType;
    }

    public void setCostType(CostType costType) {
        this.costType = costType;
    }
}