package com.hlh.aop.entity;


import com.hlh.aop.valid.NotEmpty;

import java.io.Serializable;
import java.util.Date;

public class HlhUserEntity implements Serializable,Entity{
    private static final long serialVersionUID = -6392087777310502315L;
    private Integer id;

    @NotEmpty(message = "参数username不能为空")
    private String username;

    private String password;

    private String nickname;

    private String realname;

    private String email;

    private String phone;

    private String province;

    private String city;

    private String district;

    private String address;

    private String userType;

    private Integer belongSalesman;

    private Integer belongFirstDistribution;

    private String wechatNo;

    private String cardNo;

    private String status;

    private String description;

    private String updateBy;

    private Date updateTime;

    private String createBy;

    private Date createTime;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getBelongSalesman() {
        return belongSalesman;
    }

    public void setBelongSalesman(Integer belongSalesman) {
        this.belongSalesman = belongSalesman;
    }

    public Integer getBelongFirstDistribution() {
        return belongFirstDistribution;
    }

    public void setBelongFirstDistribution(Integer belongFirstDistribution) {
        this.belongFirstDistribution = belongFirstDistribution;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HlhUserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", userType='" + userType + '\'' +
                ", belongSalesman=" + belongSalesman +
                ", belongFirstDistribution=" + belongFirstDistribution +
                ", wechatNo='" + wechatNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}