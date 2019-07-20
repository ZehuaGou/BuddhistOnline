package com.buddhist.user.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
* 修士或施主发布的消息的清单
* */
public class Inventory {
    private Integer iid; //主键自增

    private Integer uid; //外键，用户主键

    private Integer did; //外键，佛事主键

    private String content; //说明

    private String assign; //自动指派 Y/N

    private String place; //地理位置

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date earlyTime; //最早时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lateTime; //最晚时间

    private String receive; //是否接单 Y/N

    private Date publishTime; //发布时间

    private Date receiveTime; //接单时间

    private Date confirmTime; //用户确定接单时间

    private String flag; //预留字段

    private Designation designation; //佛事内容信息一对一关联清单信息

    private User user; //清单与用户关联

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign == null ? null : assign.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Date getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(Date earlyTime) {
        this.earlyTime = earlyTime;
    }

    public Date getLateTime() {
        return lateTime;
    }

    public void setLateTime(Date lateTime) {
        this.lateTime = lateTime;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive == null ? null : receive.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Designation getDesignation()
    {
        return designation;
    }

    public void setDesignation(Designation designation)
    {
        this.designation = designation;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Inventory{" +
                "iid=" + iid +
                ", uid=" + uid +
                ", did=" + did +
                ", content='" + content + '\'' +
                ", assign='" + assign + '\'' +
                ", place='" + place + '\'' +
                ", earlyTime=" + earlyTime +
                ", lateTime=" + lateTime +
                ", receive='" + receive + '\'' +
                ", publishTime=" + publishTime +
                ", receiveTime=" + receiveTime +
                ", confirmTime=" + confirmTime +
                ", flag='" + flag + '\'' +
                ", designation=" + designation +
                ", user=" + user +
                '}';
    }
}