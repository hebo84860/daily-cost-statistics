package com.yeapoo.statistics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectEntity implements Serializable {
    private String id;

    private String name;

    private String borrowerId;

    private String number;

    private String typeId;

    private String increaseTypeId;

    private String originAgency;

    private BigDecimal amount;

    private BigDecimal yieldRate;

    private BigDecimal borrowRate;

    private BigDecimal minInvestAmount;

    private Integer sellLimit;

    private String vip;

    private Byte yieldDays;

    private Integer loanPeriod;

    private Date presaleDateStart;

    private Date presaleDateEnd;

    private Date tenderDateStart;

    private Date tenderDateEnd;

    private String status;

    private String projectUrl;

    private Date refundDate;

    private Date loanDate;

    private Date repaymentDateExpected;

    private Date repaymentDate;

    private Date settlementDate;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId == null ? null : borrowerId.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getIncreaseTypeId() {
        return increaseTypeId;
    }

    public void setIncreaseTypeId(String increaseTypeId) {
        this.increaseTypeId = increaseTypeId == null ? null : increaseTypeId.trim();
    }

    public String getOriginAgency() {
        return originAgency;
    }

    public void setOriginAgency(String originAgency) {
        this.originAgency = originAgency == null ? null : originAgency.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(BigDecimal yieldRate) {
        this.yieldRate = yieldRate;
    }

    public BigDecimal getBorrowRate() {
        return borrowRate;
    }

    public void setBorrowRate(BigDecimal borrowRate) {
        this.borrowRate = borrowRate;
    }

    public BigDecimal getMinInvestAmount() {
        return minInvestAmount;
    }

    public void setMinInvestAmount(BigDecimal minInvestAmount) {
        this.minInvestAmount = minInvestAmount;
    }

    public Integer getSellLimit() {
        return sellLimit;
    }

    public void setSellLimit(Integer sellLimit) {
        this.sellLimit = sellLimit;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip == null ? null : vip.trim();
    }

    public Byte getYieldDays() {
        return yieldDays;
    }

    public void setYieldDays(Byte yieldDays) {
        this.yieldDays = yieldDays;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Date getPresaleDateStart() {
        return presaleDateStart;
    }

    public void setPresaleDateStart(Date presaleDateStart) {
        this.presaleDateStart = presaleDateStart;
    }

    public Date getPresaleDateEnd() {
        return presaleDateEnd;
    }

    public void setPresaleDateEnd(Date presaleDateEnd) {
        this.presaleDateEnd = presaleDateEnd;
    }

    public Date getTenderDateStart() {
        return tenderDateStart;
    }

    public void setTenderDateStart(Date tenderDateStart) {
        this.tenderDateStart = tenderDateStart;
    }

    public Date getTenderDateEnd() {
        return tenderDateEnd;
    }

    public void setTenderDateEnd(Date tenderDateEnd) {
        this.tenderDateEnd = tenderDateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl == null ? null : projectUrl.trim();
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getRepaymentDateExpected() {
        return repaymentDateExpected;
    }

    public void setRepaymentDateExpected(Date repaymentDateExpected) {
        this.repaymentDateExpected = repaymentDateExpected;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}