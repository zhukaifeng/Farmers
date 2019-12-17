package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class QuData implements Parcelable {


    /**
     * id : 1
     * jdname : 城东街道
     * regionmc : 1
     * mark :
     * mbrk :
     * mcrk :
     * remark :
     */

    private int id;
    private String jdname;
    private String regionmc;
    private String mark;
    private String mbrk;
    private String mcrk;
    private String remark;

    protected QuData(Parcel in) {
        id = in.readInt();
        jdname = in.readString();
        regionmc = in.readString();
        mark = in.readString();
        mbrk = in.readString();
        mcrk = in.readString();
        remark = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(jdname);
        dest.writeString(regionmc);
        dest.writeString(mark);
        dest.writeString(mbrk);
        dest.writeString(mcrk);
        dest.writeString(remark);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuData> CREATOR = new Creator<QuData>() {
        @Override
        public QuData createFromParcel(Parcel in) {
            return new QuData(in);
        }

        @Override
        public QuData[] newArray(int size) {
            return new QuData[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJdname() {
        return jdname;
    }

    public void setJdname(String jdname) {
        this.jdname = jdname;
    }

    public String getRegionmc() {
        return regionmc;
    }

    public void setRegionmc(String regionmc) {
        this.regionmc = regionmc;
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
