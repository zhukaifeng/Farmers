package com.osiris.farmers.model;

public class SerachGoodData {


    /**
     * id : 874
     * commoditynm : 大白菜
     * comtype : 17
     * commodibz : 农残,有机磷,拟除虫菊酯,有机氯
     * commobz :
     * beifen :
     * mark :
     * mbrk :
     * mcrk :
     * remark :
     */

    private int id;
    private String commoditynm;
    private int comtype;
    private String commodibz;
    private String commobz;
    private String beifen;
    private String mark;
    private String mbrk;
    private String mcrk;
    private String remark;
    private boolean Select;

    public boolean isSelect() {
        return Select;
    }

    public void setSelect(boolean select) {
        Select = select;
    }

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
}
