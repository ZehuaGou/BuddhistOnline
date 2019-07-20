package com.buddhist.user.model;

import java.math.BigDecimal;

/*
* 佛事内容实体类
* */
public class Designation {
    private Integer did; //主键自增

    private Integer cid; //外键，分类表主键

    private String name; //名称

    private BigDecimal price; //额定布施（元）

    private String content; //说明

    private String flag; //预留字段

    private Classify classify; //佛事内容关联佛事分类

    private Inventory inventory; //佛事内容与清单信息关联

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Classify getClassify()
    {
        return classify;
    }

    public void setClassify(Classify classify)
    {
        this.classify = classify;
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
        return "Designation{" +
                "did=" + did +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                ", flag='" + flag + '\'' +
                ", classify=" + classify +
                ", inventory=" + inventory +
                '}';
    }
}