package com.osiris.farmers.model;

public class Product {

    /**
     * id : 1519
     * commoditynm : 大白菜
     * comtype : 34
     * commodibz : 农残,拟除虫菊酯
     * commobz :
     * beifen :
     * tupian : null
     * mark :
     * mbrk :
     * mcrk :
     * remark :
     * descriptionnm : 蔬菜及蔬菜制品
     */

    private int id;
    private String commoditynm;
    private int comtype;
    private String commodibz;
    private String commobz;
    private String beifen;
    private Object tupian;
    private String mark;
    private String mbrk;
    private String mcrk;
    private String remark;
    private String descriptionnm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommoditynm() {
        return commoditynm;
    }

    public void setCommoditynm(String commoditynm) {
        this.commoditynm = commoditynm;
    }

    public int getComtype() {
        return comtype;
    }

    public void setComtype(int comtype) {
        this.comtype = comtype;
    }

    public String getCommodibz() {
        return commodibz;
    }

    public void setCommodibz(String commodibz) {
        this.commodibz = commodibz;
    }

    public String getCommobz() {
        return commobz;
    }

    public void setCommobz(String commobz) {
        this.commobz = commobz;
    }

    public String getBeifen() {
        return beifen;
    }

    public void setBeifen(String beifen) {
        this.beifen = beifen;
    }

    public Object getTupian() {
        return tupian;
    }

    public void setTupian(Object tupian) {
        this.tupian = tupian;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMbrk() {
        return mbrk;
    }

    public void setMbrk(String mbrk) {
        this.mbrk = mbrk;
    }

    public String getMcrk() {
        return mcrk;
    }

    public void setMcrk(String mcrk) {
        this.mcrk = mcrk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescriptionnm() {
        return descriptionnm;
    }

    public void setDescriptionnm(String descriptionnm) {
        this.descriptionnm = descriptionnm;
    }
}
