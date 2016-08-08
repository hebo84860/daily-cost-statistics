package com.yeapoo.statistics.controller.param;

import com.yeapoo.statistics.constant.CostDetail;
import com.yeapoo.statistics.constant.CostType;
import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.controller.base.BaseParam;
import com.yeapoo.statistics.controller.base.Pagination;
import com.yeapoo.statistics.entity.CostEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class CostListParam implements Serializable, BaseParam {
    private static final long serialVersionUID = 4899411666660399100L;

    private CostEntity costEntity = new CostEntity();

    private Pagination pagination = new Pagination();

    public CostEntity getCostEntity() {
        return costEntity;
    }

    public void setCostEntity(CostEntity costEntity) {
        this.costEntity = costEntity;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
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

    public int getPage() {
        return pagination.getPage();
    }

    public boolean isSearch() {
        return pagination.isSearch();
    }

    public int getStartRow() {
        return pagination.getStartRow();
    }

    public String getSord() {
        return pagination.getSord();
    }

    public int getEndRow() {
        return pagination.getEndRow();
    }

    public void setPage(int page) {
        pagination.setPage(page);
    }

    public void setRows(int rows) {
        pagination.setRows(rows);
    }

    public String getSidx() {
        return pagination.getSidx();
    }

    public int getTotal() {
        return pagination.getTotal();
    }

    public int getRecords() {
        return pagination.getRecords();
    }

    public void countRecords(int records) {
        pagination.countRecords(records);
    }

    public void setSidx(String sidx) {
        pagination.setSidx(sidx);
    }

    public void setTotal(int total) {
        pagination.setTotal(total);
    }

    public void setSearch(boolean search) {
        pagination.setSearch(search);
    }

    public void setSord(String sord) {
        pagination.setSord(sord);
    }

    public void setRecords(int records) {
        pagination.setRecords(records);
    }

    public int getRows() {
        return pagination.getRows();
    }

    public void setRowsByCustom(int customRows) {
        pagination.setRowsByCustom(customRows);
    }
}
