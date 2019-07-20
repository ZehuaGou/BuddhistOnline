package com.buddhist.user.model;

import java.math.BigDecimal;

/*
* 账单实体类
* */
public class Bill {
    private Integer bid; //主键自增

    private Integer uid; //外键，用户主键

    private Integer oid; //外键，订单主键

    private Integer did; //外键，佛事名称主键

    private String identify; //身份，修士或用户 X/Y

    private BigDecimal price; //额定布施（元）通过佛事名称表获取

    private BigDecimal reality; //实际交易金额

    private String explain; //说明

    private String flag; //预留字段

    private OrderForm orderForm; //账单关联订单

    private Inventory inventory; //账单与清单关联

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getReality() {
        return reality;
    }

    public void setReality(BigDecimal reality) {
        this.reality = reality;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public OrderForm getOrderForm()
    {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm)
    {
        this.orderForm = orderForm;
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
        return "Bill{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", oid=" + oid +
                ", did=" + did +
                ", identify='" + identify + '\'' +
                ", price=" + price +
                ", reality=" + reality +
                ", explain='" + explain + '\'' +
                ", flag='" + flag + '\'' +
                ", orderForm=" + orderForm +
                ", inventory=" + inventory +
                '}';
    }
}