package com.osiris.farmers.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class MarketManagerEvaluate implements Parcelable {


    /**
     * id : 33
     * jyhid : 67
     * pingjianr : 5|非常满意|12,4|满意|13,3|一般|14,5|非常满意|15
     * pingjiaxj :
     * marketid : 20
     * marketnm : 观音山新城菜市场
     * tsremark : 53
     * userid : null
     * username : null
     * llrq : 2019-11-17 14:27:49
     * mark :
     * mbrk :
     * mcrk : 张袁葛
     * remark :
     */

    private int id;
    private String jyhid;
    private String pingjianr;
    private String pingjiaxj;
    private String marketid;
    private String marketnm;
    private String tsremark;
    private Object userid;
    private String username;
    private String llrq;
    private String mark;
    private String mbrk;
    private String mcrk;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJyhid() {
        return jyhid;
    }

    public void setJyhid(String jyhid) {
        this.jyhid = jyhid;
    }

    public String getPingjianr() {
        return pingjianr;
    }

    public void setPingjianr(String pingjianr) {
        this.pingjianr = pingjianr;
    }

    public String getPingjiaxj() {
        return pingjiaxj;
    }

    public void setPingjiaxj(String pingjiaxj) {
        this.pingjiaxj = pingjiaxj;
    }

    public String getMarketid() {
        return marketid;
    }

    public void setMarketid(String marketid) {
        this.marketid = marketid;
    }

    public String getMarketnm() {
        return marketnm;
    }

    public void setMarketnm(String marketnm) {
        this.marketnm = marketnm;
    }

    public String getTsremark() {
        return tsremark;
    }

    public void setTsremark(String tsremark) {
        this.tsremark = tsremark;
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLlrq() {
        return llrq;
    }

    public void setLlrq(String llrq) {
        this.llrq = llrq;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
