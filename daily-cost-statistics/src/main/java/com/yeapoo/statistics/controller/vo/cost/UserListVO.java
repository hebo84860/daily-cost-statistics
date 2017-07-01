package com.yeapoo.statistics.controller.vo.cost;


import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.constant.UserRole;
import com.yeapoo.statistics.entity.UserEntity;
import com.yeapoo.statistics.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by hebo on 2016/8/3.
 */
public class UserListVO implements Serializable {
    private static final long serialVersionUID = 6248410097915005938L;

    private UserEntity userEntity;

    private String userRoleStr;
    private String statusStr;
    private String createTimeStr;
    private String updateTimeStr;

    public UserListVO(){ }
    public UserListVO(UserEntity userEntity){
        this.userEntity=userEntity;
    }

    public String getUserRoleStr() {
        if (this.getUserRole()!=null){
            this.getUserRole().getCnName();
        }
        return userRoleStr;
    }

    public void setUserRoleStr(String userRoleStr) {
        this.userRoleStr = userRoleStr;
    }

    public String getStatusStr() {
        if (this.getStatus()!=null){
            return this.getStatus().getCnName();
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getCreateTimeStr() {
        if (this.getCreateTime()!=null){
            return DateUtil.date2String(this.getCreateTime(), DateUtil.FORMAT_DATETIME2);
        }
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        if (this.getUpdateTime()!=null){
            return DateUtil.date2String(this.getUpdateTime(), DateUtil.FORMAT_DATETIME2);
        }
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getId() {
        return userEntity.getId();
    }

    public Boolean getEnabled() {
        return userEntity.getEnabled();
    }

    public void setRecommendSecondId(Integer recommendSecondId) {
        userEntity.setRecommendSecondId(recommendSecondId);
    }

    public Byte getUpdateUser() {
        return userEntity.getUpdateUser();
    }

    public void setBelongSalesmanId(Integer belongSalesmanId) {
        userEntity.setBelongSalesmanId(belongSalesmanId);
    }

    public Integer getBelongSecondDistribution() {
        return userEntity.getBelongSecondDistribution();
    }

    public void setUpdateTime(Date updateTime) {
        userEntity.setUpdateTime(updateTime);
    }

    public void setPhone(String phone) {
        userEntity.setPhone(phone);
    }

    public String getRecommendFirstName() {
        return userEntity.getRecommendFirstName();
    }

    public String getRealname() {
        return userEntity.getRealname();
    }

    public void setBelongFirstDistributionId(Integer belongFirstDistributionId) {
        userEntity.setBelongFirstDistributionId(belongFirstDistributionId);
    }

    public String getJob() {
        return userEntity.getJob();
    }

    public void setUserRole(UserRole userRole) {
        userEntity.setUserRole(userRole);
    }

    public void setUsername(String username) {
        userEntity.setUsername(username);
    }

    public void setEmail(String email) {
        userEntity.setEmail(email);
    }

    public Integer getBelongSalesmanId() {
        return userEntity.getBelongSalesmanId();
    }

    public Integer getBelongFirstDistributionId() {
        return userEntity.getBelongFirstDistributionId();
    }

    public Date getUpdateTime() {
        return userEntity.getUpdateTime();
    }

    public void setId(Integer id) {
        userEntity.setId(id);
    }

    public UserRole getUserRole() {
        return userEntity.getUserRole();
    }

    public Status getStatus() {
        return userEntity.getStatus();
    }

    public Byte getCreateUser() {
        return userEntity.getCreateUser();
    }

    public void setRecommendUsername(String recommendUsername) {
        userEntity.setRecommendUsername(recommendUsername);
    }

    public void setPassword(String password) {
        userEntity.setPassword(password);
    }

    public void setBelongSecondDistribution(Integer belongSecondDistribution) {
        userEntity.setBelongSecondDistribution(belongSecondDistribution);
    }

    public String getUsername() {
        return userEntity.getUsername();
    }

    public void setStatus(Status status) {
        userEntity.setStatus(status);
    }

    public String getEmail() {
        return userEntity.getEmail();
    }

    public void setJob(String job) {
        userEntity.setJob(job);
    }

    public void setEnabled(Boolean enabled) {
        userEntity.setEnabled(enabled);
    }

    public String getPassword() {
        return userEntity.getPassword();
    }

    public void setCreateUser(Byte createUser) {
        userEntity.setCreateUser(createUser);
    }

    public void setRecommendFirstId(Integer recommendFirstId) {
        userEntity.setRecommendFirstId(recommendFirstId);
    }

    public void setRealname(String realname) {
        userEntity.setRealname(realname);
    }

    public Date getCreateTime() {
        return userEntity.getCreateTime();
    }

    public String getRecommendUsername() {
        return userEntity.getRecommendUsername();
    }

    public String getPhone() {
        return userEntity.getPhone();
    }

    public Integer getRecommendFirstId() {
        return userEntity.getRecommendFirstId();
    }

    public String getRecommendSecondName() {
        return userEntity.getRecommendSecondName();
    }

    public void setCreateTime(Date createTime) {
        userEntity.setCreateTime(createTime);
    }

    public void setUpdateUser(Byte updateUser) {
        userEntity.setUpdateUser(updateUser);
    }

    public Integer getRecommendSecondId() {
        return userEntity.getRecommendSecondId();
    }

    public void setRecommendSecondName(String recommendSecondName) {
        userEntity.setRecommendSecondName(recommendSecondName);
    }

    public void setRecommendFirstName(String recommendFirstName) {
        userEntity.setRecommendFirstName(recommendFirstName);
    }
}
