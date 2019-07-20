package com.buddhist.user.model;

/*
* 订单实体类
* */
public class OrderForm {
    private Integer oid; //主键自增

    private Integer sid; //外键，施主id

    private Integer xid; //外键，修士id

    private Integer did; //外键，佛事主键

    private String answerOne; //回向文一，有模板

    private String answerTwo; //回向文二，必填字段

    private String playUrl; //直播链接

    private String finish; //完成与否 Y/N

    private Integer grade; //星级（1-5）

    private String evaluate; //评价

    private String require; //特殊要求

    private String message; //用户指定订单后给其他或指定订单回复信息

    private String flag; //订单是否被指定 Y/N

    private User donorUser; //订单与施主关联

    private User monkUser; //订单与修士关联

    private Inventory inventory; //订单与清单信息关联

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getXid() {
        return xid;
    }

    public void setXid(Integer xid) {
        this.xid = xid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne == null ? null : answerOne.trim();
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo == null ? null : answerTwo.trim();
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require == null ? null : require.trim();
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl == null ? null : playUrl.trim();
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish == null ? null : finish.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public User getDonorUser()
    {
        return donorUser;
    }

    public void setDonorUser(User donorUser)
    {
        this.donorUser = donorUser;
    }

    public User getMonkUser()
    {
        return monkUser;
    }

    public void setMonkUser(User monkUser)
    {
        this.monkUser = monkUser;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    @Override
    public String toString()
    {
        return "OrderForm{" +
                "oid=" + oid +
                ", sid=" + sid +
                ", xid=" + xid +
                ", did=" + did +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", finish='" + finish + '\'' +
                ", grade=" + grade +
                ", evaluate='" + evaluate + '\'' +
                ", require='" + require + '\'' +
                ", message='" + message + '\'' +
                ", flag='" + flag + '\'' +
                ", donorUser=" + donorUser +
                ", monkUser=" + monkUser +
                ", inventory=" + inventory +
                '}';
    }
}