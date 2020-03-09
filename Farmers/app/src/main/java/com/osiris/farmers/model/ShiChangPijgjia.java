package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShiChangPijgjia implements Parcelable {


    /**
     * id : 37
     * jyhid : 163
     * pingjianr : 2|差|13,3|一般|15
     * pingjiaxj :
     * marketid : 20
     * marketnm : 观音山新城菜市场
     * tsremark : 53
     * userid : null
     * username : 阎绍雨
     * llrq : 2020-02-19 10:35:48
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

    protected ShiChangPijgjia(Parcel in) {
        id = in.readInt();
        jyhid = in.readString();
        pingjianr = in.readString();
        pingjiaxj = in.readString();
        marketid = in.readString();
        marketnm = in.readString();
        tsremark = in.readString();
        username = in.readString();
        llrq = in.readString();
        mark = in.readString();
        mbrk = in.readString();
        mcrk = in.readString();
        remark = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(jyhid);
        dest.writeString(pingjianr);
        dest.writeString(pingjiaxj);
        dest.writeString(marketid);
        dest.writeString(marketnm);
        dest.writeString(tsremark);
        dest.writeString(username);
        dest.writeString(llrq);
        dest.writeString(mark);
        dest.writeString(mbrk);
        dest.writeString(mcrk);
        dest.writeString(remark);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShiChangPijgjia> CREATOR = new Creator<ShiChangPijgjia>() {
        @Override
        public ShiChangPijgjia createFromParcel(Parcel in) {
            return new ShiChangPijgjia(in);
        }

        @Override
        public ShiChangPijgjia[] newArray(int size) {
            return new ShiChangPijgjia[size];
        }
    };

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
}
