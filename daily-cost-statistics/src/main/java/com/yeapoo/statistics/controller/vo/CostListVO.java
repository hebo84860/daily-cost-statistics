package com.yeapoo.statistics.controller.vo;

import com.yeapoo.statistics.constant.CostDetail;
import com.yeapoo.statistics.constant.CostType;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.entity.CostEntity;
import com.yeapoo.statistics.util.DateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class CostListVO implements Serializable {
    private static final long serialVersionUID = 6248410097915005938L;
    private CostEntity costEntity;

    private String statusStr;
    private String costDetailStr;
    private String costTypeStr;
    private String costTimeStr;
    private String createTimeStr;
    private String updateTimeStr;

    public CostListVO(){}
    public CostListVO( CostEntity costEntity){
        this.costEntity = costEntity;
    }

    public CostEntity getCostEntity() {
        return costEntity;
    }

    public void setCostEntity(CostEntity costEntity) {
        this.costEntity = costEntity;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getCostDetailStr() {
        return costDetailStr;
    }

    public void setCostDetailStr(String costDetailStr) {
        this.costDetailStr = costDetailStr;
    }

    public String getCostTypeStr() {
        if (this.getCostTime()!=null){
            return DateUtil.date2String(this.getCostTime(), DateUtil.FORMAT_DATETIME);
        }
        return costTypeStr;
    }

    public void setCostTypeStr(String costTypeStr) {
        this.costTypeStr = costTypeStr;
    }

    public String getCostTimeStr() {
        return costTimeStr;
    }

    public void setCostTimeStr(String costTimeStr) {
        this.costTimeStr = costTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public Long getId() {
        return costEntity.getId();
    }

    public Date getCostTime() {
        return costEntity.getCostTime();
    }

    public void setCreateTime(Date createTime) {
        costEntity.setCreateTime(createTime);
    }

    public BigDecimal getCostAmount() {
        return costEntity.getCostAmount();
    }

    public void setCostTime(Date costTime) {
        costEntity.setCostTime(costTime);
    }

    public Date getCreateTime() {
        return costEntity.getCreateTime();
    }

    public String getCostUserId() {
        return costEntity.getCostUserId();
    }

    public void setCostUserName(String costUserName) {
        costEntity.setCostUserName(costUserName);
    }

    public void setReason(String reason) {
        costEntity.setReason(reason);
    }

    public void setCostAmount(BigDecimal costAmount) {
        costEntity.setCostAmount(costAmount);
    }

    public void setUpdateTime(Date updateTime) {
        costEntity.setUpdateTime(updateTime);
    }

    public void setCostUserId(String costUserId) {
        costEntity.setCostUserId(costUserId);
    }

    public Status getStatus() {
        return costEntity.getStatus();
    }

    public void setStatus(Status status) {
        costEntity.setStatus(status);
    }

    public void setCreateBy(String createBy) {
        costEntity.setCreateBy(createBy);
    }

    public void setUpdateBy(String updateBy) {
        costEntity.setUpdateBy(updateBy);
    }

    public String getCostUserName() {
        return costEntity.getCostUserName();
    }

    public CostDetail getCostDetail() {
        return costEntity.getCostDetail();
    }

    public String getDescription() {
        return costEntity.getDescription();
    }

    public void setId(Long id) {
        costEntity.setId(id);
    }

    public String getUpdateBy() {
        return costEntity.getUpdateBy();
    }

    public String getReason() {
        return costEntity.getReason();
    }

    public void setDescription(String description) {
        costEntity.setDescription(description);
    }

    public CostType getCostType() {
        return costEntity.getCostType();
    }

    public void setCostType(CostType costType) {
        costEntity.setCostType(costType);
    }

    public String getCreateBy() {
        return costEntity.getCreateBy();
    }

    public Date getUpdateTime() {
        return costEntity.getUpdateTime();
    }

    public void setCostDetail(CostDetail costDetail) {
        costEntity.setCostDetail(costDetail);
    }
}
