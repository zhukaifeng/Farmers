package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {


    /**
     * id : 15
     * ypmc : 青菜
     * shengid : 江苏省
     * shiid : 南通市
     * quid : 崇川区
     * jiedaoid : 观音山街道
     * scid : 观音山新城菜市场
     * scmc :
     * cysl :
     * twhid : 蔬菜09
     * twhmc :
     * jcyid :
     * jcymc :
     * byo :
     * byt :
     * bys :
     * byz :
     * byd :
     * llrq : 2019-12-12 10:47:03
     * mark :
     * mbrk :
     * mcrk :
     * remark :
     */

    private int id;
    private String ypmc;
    private String shengid;
    private String shiid;
    private String quid;
    private String jiedaoid;
    private String scid;
    private String scmc;
    private String cysl;
    private String twhid;
    private String twhmc;
    private String jcyid;
    private String jcymc;
    private String byo;
    private String byt;
    private String bys;
    private String byz;
    private String byd;
    private String llrq;
    private String mark;
    private String mbrk;
    private String mcrk;
    private String remark;

    protected Task(Parcel in) {
        id = in.readInt();
        ypmc = in.readString();
        shengid = in.readString();
        shiid = in.readString();
        quid = in.readString();
        jiedaoid = in.readString();
        scid = in.readString();
        scmc = in.readString();
        cysl = in.readString();
        twhid = in.readString();
        twhmc = in.readString();
        jcyid = in.readString();
        jcymc = in.readString();
        byo = in.readString();
        byt = in.readString();
        bys = in.readString();
        byz = in.readString();
        byd = in.readString();
        llrq = in.readString();
        mark = in.readString();
        mbrk = in.readString();
        mcrk = in.readString();
        remark = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(ypmc);
        dest.writeString(shengid);
        dest.writeString(shiid);
        dest.writeString(quid);
        dest.writeString(jiedaoid);
        dest.writeString(scid);
        dest.writeString(scmc);
        dest.writeString(cysl);
        dest.writeString(twhid);
        dest.writeString(twhmc);
        dest.writeString(jcyid);
        dest.writeString(jcymc);
        dest.writeString(byo);
        dest.writeString(byt);
        dest.writeString(bys);
        dest.writeString(byz);
        dest.writeString(byd);
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

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getShengid() {
        return shengid;
    }

    public void setShengid(String shengid) {
        this.shengid = shengid;
    }

    public String getShiid() {
        return shiid;
    }

    public void setShiid(String shiid) {
        this.shiid = shiid;
    }

    public String getQuid() {
        return quid;
    }

    public void setQuid(String quid) {
        this.quid = quid;
    }

    public String getJiedaoid() {
        return jiedaoid;
    }

    public void setJiedaoid(String jiedaoid) {
        this.jiedaoid = jiedaoid;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getScmc() {
        return scmc;
    }

    public void setScmc(String scmc) {
        this.scmc = scmc;
    }

    public String getCysl() {
        return cysl;
    }

    public void setCysl(String cysl) {
        this.cysl = cysl;
    }

    public String getTwhid() {
        return twhid;
    }

    public void setTwhid(String twhid) {
        this.twhid = twhid;
    }

    public String getTwhmc() {
        return twhmc;
    }

    public void setTwhmc(String twhmc) {
        this.twhmc = twhmc;
    }

    public String getJcyid() {
        return jcyid;
    }

    public void setJcyid(String jcyid) {
        this.jcyid = jcyid;
    }

    public String getJcymc() {
        return jcymc;
    }

    public void setJcymc(String jcymc) {
        this.jcymc = jcymc;
    }

    public String getByo() {
        return byo;
    }

    public void setByo(String byo) {
        this.byo = byo;
    }

    public String getByt() {
        return byt;
    }

    public void setByt(String byt) {
        this.byt = byt;
    }

    public String getBys() {
        return bys;
    }

    public void setBys(String bys) {
        this.bys = bys;
    }

    public String getByz() {
        return byz;
    }

    public void setByz(String byz) {
        this.byz = byz;
    }

    public String getByd() {
        return byd;
    }

    public void setByd(String byd) {
        this.byd = byd;
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
