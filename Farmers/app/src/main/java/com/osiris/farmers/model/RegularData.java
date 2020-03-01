package com.osiris.farmers.model;

public class RegularData {

    /**
     * id : 14
     * zlkmc : 食品生产许可分类目录公告（2016年第23号）
     * jtnr : 1576573109790.pdf
     * leibie : 2
     * scsj : 2016-01-22
     * mark : 2016-01-22
     * mbrk : 国家食品药品监督管理总局
     * mcrk : null
     * remark : 食品生产许可分类目录.pdf
     */

    private int id;
    private String zlkmc;
    private String jtnr;
    private String leibie;
    private String scsj;
    private String mark;
    private String mbrk;
    private Object mcrk;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZlkmc() {
        return zlkmc;
    }

    public void setZlkmc(String zlkmc) {
        this.zlkmc = zlkmc;
    }

    public String getJtnr() {
        return jtnr;
    }

    public void setJtnr(String jtnr) {
        this.jtnr = jtnr;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getScsj() {
        return scsj;
    }

    public void setScsj(String scsj) {
        this.scsj = scsj;
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

    public Object getMcrk() {
        return mcrk;
    }

    public void setMcrk(Object mcrk) {
        this.mcrk = mcrk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
