package com.yeapoo.statistics.entity;

import com.yeapoo.statistics.constant.Status;
import com.yeapoo.statistics.constant.UserRole;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable{
    private static final long serialVersionUID = 6946565290744560733L;
    private Integer id;

    private String username;

    private String realname;

    private String password;
    private String recommendUsername;

    private String phone;

    private String email;

    private UserRole userRole;

    private Integer recommendFirstId;

    private String recommendFirstName;

    private Integer recommendSecondId;

    private String recommendSecondName;

    private Integer belongSalesmanId;

    private Integer belongFirstDistributionId;

    private Integer belongSecondDistribution;

    private String job;

    private Status status;

    private Date createTime;

    private Date updateTime;

    private Byte createUser;

    private Byte updateUser;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecommendUsername() {
        return recommendUsername;
    }

    public void setRecommendUsername(String recommendUsername) {
        this.recommendUsername = recommendUsername;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Integer getRecommendFirstId() {
        return recommendFirstId;
    }

    public void setRecommendFirstId(Integer recommendFirstId) {
        this.recommendFirstId = recommendFirstId;
    }

    public String getRecommendFirstName() {
        return recommendFirstName;
    }

    public void setRecommendFirstName(String recommendFirstName) {
        this.recommendFirstName = recommendFirstName;
    }

    public Integer getRecommendSecondId() {
        return recommendSecondId;
    }

    public void setRecommendSecondId(Integer recommendSecondId) {
        this.recommendSecondId = recommendSecondId;
    }

    public String getRecommendSecondName() {
        return recommendSecondName;
    }

    public void setRecommendSecondName(String recommendSecondName) {
        this.recommendSecondName = recommendSecondName;
    }

    public Integer getBelongSalesmanId() {
        return belongSalesmanId;
    }

    public void setBelongSalesmanId(Integer belongSalesmanId) {
        this.belongSalesmanId = belongSalesmanId;
    }

    public Integer getBelongFirstDistributionId() {
        return belongFirstDistributionId;
    }

    public void setBelongFirstDistributionId(Integer belongFirstDistributionId) {
        this.belongFirstDistributionId = belongFirstDistributionId;
    }

    public Integer getBelongSecondDistribution() {
        return belongSecondDistribution;
    }

    public void setBelongSecondDistribution(Integer belongSecondDistribution) {
        this.belongSecondDistribution = belongSecondDistribution;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Byte getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Byte createUser) {
        this.createUser = createUser;
    }

    public Byte getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Byte updateUser) {
        this.updateUser = updateUser;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}