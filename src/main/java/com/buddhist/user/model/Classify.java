package com.buddhist.user.model;

/*
* 佛事分类实体类
* */
public class Classify {
    private Integer cid; //主键自增

    private String typeOne; //类别一

    private String name; //名称

    private String content; //事件说明

    private String flag; //预留字段

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne == null ? null : typeOne.trim();
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString()
    {
        return "Classify{" +
                "cid=" + cid +
                ", typeOne='" + typeOne + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}