package com.yeapoo.statistics.controller.param;


import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.constant.UserRole;
import com.yeapoo.statistics.controller.base.BaseParam;
import com.yeapoo.statistics.controller.base.Pagination;
import com.yeapoo.statistics.entity.UserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class UserEntityRequest implements Serializable, BaseParam {
    private static final long serialVersionUID = 6760399220085621530L;

    private UserEntity userEntity = new UserEntity();

    private Pagination pagination = new Pagination();
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getId() {
        return userEntity.getId();
    }

    public void setJob(String job) {
        userEntity.setJob(job);
    }

    public Byte getUpdateUser() {
        return userEntity.getUpdateUser();
    }

    public String getPassword() {
        return userEntity.getPassword();
    }

    public void setRecommendUsername(String recommendUsername) {
        userEntity.setRecommendUsername(recommendUsername);
    }

    public void setRecommendFirstName(String recommendFirstName) {
        userEntity.setRecommendFirstName(recommendFirstName);
    }

    public String getUsername() {
        return userEntity.getUsername();
    }

    public String getRecommendFirstName() {
        return userEntity.getRecommendFirstName();
    }

    public Byte getCreateUser() {
        return userEntity.getCreateUser();
    }

    public void setCreateUser(Byte createUser) {
        userEntity.setCreateUser(createUser);
    }

    public void setBelongFirstDistributionId(Integer belongFirstDistributionId) {
        userEntity.setBelongFirstDistributionId(belongFirstDistributionId);
    }

    public Status getStatus() {
        return userEntity.getStatus();
    }

    public void setCreateTime(Date createTime) {
        userEntity.setCreateTime(createTime);
    }

    public void setUsername(String username) {
        userEntity.setUsername(username);
    }

    public Integer getRecommendFirstId() {
        return userEntity.getRecommendFirstId();
    }

    public Integer getRecommendSecondId() {
        return userEntity.getRecommendSecondId();
    }

    public void setBelongSalesmanId(Integer belongSalesmanId) {
        userEntity.setBelongSalesmanId(belongSalesmanId);
    }

    public String getJob() {
        return userEntity.getJob();
    }

    public UserRole getUserRole() {
        return userEntity.getUserRole();
    }

    public String getPhone() {
        return userEntity.getPhone();
    }

    public void setRecommendFirstId(Integer recommendFirstId) {
        userEntity.setRecommendFirstId(recommendFirstId);
    }

    public void setRecommendSecondName(String recommendSecondName) {
        userEntity.setRecommendSecondName(recommendSecondName);
    }

    public String getRecommendUsername() {
        return userEntity.getRecommendUsername();
    }

    public void setStatus(Status status) {
        userEntity.setStatus(status);
    }

    public Date getUpdateTime() {
        return userEntity.getUpdateTime();
    }

    public Integer getBelongSecondDistribution() {
        return userEntity.getBelongSecondDistribution();
    }

    public void setBelongSecondDistribution(Integer belongSecondDistribution) {
        userEntity.setBelongSecondDistribution(belongSecondDistribution);
    }

    public void setRecommendSecondId(Integer recommendSecondId) {
        userEntity.setRecommendSecondId(recommendSecondId);
    }

    public Integer getBelongSalesmanId() {
        return userEntity.getBelongSalesmanId();
    }

    public void setId(Integer id) {
        userEntity.setId(id);
    }

    public void setRealname(String realname) {
        userEntity.setRealname(realname);
    }

    public String getEmail() {
        return userEntity.getEmail();
    }

    public void setPassword(String password) {
        userEntity.setPassword(password);
    }

    public Integer getBelongFirstDistributionId() {
        return userEntity.getBelongFirstDistributionId();
    }

    public Date getCreateTime() {
        return userEntity.getCreateTime();
    }

    public void setEnabled(Boolean enabled) {
        userEntity.setEnabled(enabled);
    }

    public String getRealname() {
        return userEntity.getRealname();
    }

    public void setPhone(String phone) {
        userEntity.setPhone(phone);
    }

    public String getRecommendSecondName() {
        return userEntity.getRecommendSecondName();
    }

    public void setEmail(String email) {
        userEntity.setEmail(email);
    }

    public void setUserRole(UserRole userRole) {
        userEntity.setUserRole(userRole);
    }

    public void setUpdateTime(Date updateTime) {
        userEntity.setUpdateTime(updateTime);
    }

    public Boolean getEnabled() {
        return userEntity.getEnabled();
    }

    public void setUpdateUser(Byte updateUser) {
        userEntity.setUpdateUser(updateUser);
    }

    public int getPage() {
        return pagination.getPage();
    }

    public String getSord() {
        return pagination.getSord();
    }

    public void setSearch(boolean search) {
        pagination.setSearch(search);
    }

    public void countRecords(int records) {
        pagination.countRecords(records);
    }

    public void setTotal(int total) {
        pagination.setTotal(total);
    }

    public int getEndRow() {
        return pagination.getEndRow();
    }

    public int getRecords() {
        return pagination.getRecords();
    }

    public int getTotal() {
        return pagination.getTotal();
    }

    public void setRecords(int records) {
        pagination.setRecords(records);
    }

    public void setRowsByCustom(int customRows) {
        pagination.setRowsByCustom(customRows);
    }

    public boolean isSearch() {
        return pagination.isSearch();
    }

    public int getRows() {
        return pagination.getRows();
    }

    public int getStartRow() {
        return pagination.getStartRow();
    }

    public void setStratRecodes(int stratRecodes) {
        pagination.setStratRecodes(stratRecodes);
    }

    public void setRows(int rows) {
        pagination.setRows(rows);
    }

    public void setPage(int page) {
        pagination.setPage(page);
    }

    public void setSidx(String sidx) {
        pagination.setSidx(sidx);
    }

    public void setSord(String sord) {
        pagination.setSord(sord);
    }

    public String getSidx() {
        return pagination.getSidx();
    }

    public int getStratRecodes() {
        return pagination.getStratRecodes();
    }
}
