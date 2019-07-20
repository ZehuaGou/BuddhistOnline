package com.buddhist.user.model;

import java.math.BigDecimal;
import java.util.Date;

/*
* 用户实体类
* */
public class User {
    private Integer uid; //主键自增

    private String name; //姓名

    private String password; //密码

    private String phone; //电话

    private String sex; //性别

    private String idCard; //身份证号

    private Date rTime; //注册时间

    private String identify; //身份，修士或用户 X/Y

    private Integer acceptOrds; //施修单数

    private Integer grade; //施修星级（1-5）

    private BigDecimal acceptMoney; //施修总金额

    private Integer donationOrds; //布施单数

    private BigDecimal donationMoney; //布施金额

    private String flag; //预留字段

    public User()
    {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public Integer getAcceptOrds() {
        return acceptOrds;
    }

    public void setAcceptOrds(Integer acceptOrds) {
        this.acceptOrds = acceptOrds;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public BigDecimal getAcceptMoney() {
        return acceptMoney;
    }

    public void setAcceptMoney(BigDecimal acceptMoney) {
        this.acceptMoney = acceptMoney;
    }

    public Integer getDonationOrds() {
        return donationOrds;
    }

    public void setDonationOrds(Integer donationOrds) {
        this.donationOrds = donationOrds;
    }

    public BigDecimal getDonationMoney() {
        return donationMoney;
    }

    public void setDonationMoney(BigDecimal donationMoney) {
        this.donationMoney = donationMoney;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString()
    {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", rTime=" + rTime +
                ", identify='" + identify + '\'' +
                ", acceptOrds=" + acceptOrds +
                ", grade=" + grade +
                ", acceptMoney=" + acceptMoney +
                ", donationOrds=" + donationOrds +
                ", donationMoney=" + donationMoney +
                ", flag='" + flag + '\'' +
                '}';
    }
}