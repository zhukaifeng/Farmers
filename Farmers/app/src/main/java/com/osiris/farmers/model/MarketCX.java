package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MarketCX {


    /**
     * result : 0
     * message : 1
     * data : [{"id":4,"regionid":"2","marketnm":"观音山菜市场","tel":"13951321655","address":"观音山太平北路366号","yyzz":"91321100MA1P212U30","ren":"王建","zhuren":"王建","phone":"13951321655","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":20,"regionid":"2","marketnm":"观音山新城菜市场","tel":"0513-89079342","address":"世纪大道盘香路交叉路口，中南世纪花城二期东北角","yyzz":"91320602MA1Q0K2U53","ren":"戴丽萍","zhuren":"戴丽萍","phone":"13773610590","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""}]
     */

    private int result;
    private String message;
    private List<DataBean> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * id : 4
         * regionid : 2
         * marketnm : 观音山菜市场
         * tel : 13951321655
         * address : 观音山太平北路366号
         * yyzz : 91321100MA1P212U30
         * ren : 王建
         * zhuren : 王建
         * phone : 13951321655
         * beifen : 民营
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         */

        private int id;
        private String regionid;
        private String marketnm;
        private String tel;
        private String address;
        private String yyzz;
        private String ren;
        private String zhuren;
        private String phone;
        private String beifen;
        private String mark;
        private String mbrk;
        private String mcrk;
        private String remark;

        protected DataBean(Parcel in) {
            id = in.readInt();
            regionid = in.readString();
            marketnm = in.readString();
            tel = in.readString();
            address = in.readString();
            yyzz = in.readString();
            ren = in.readString();
            zhuren = in.readString();
            phone = in.readString();
            beifen = in.readString();
            mark = in.readString();
            mbrk = in.readString();
            mcrk = in.readString();
            remark = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRegionid() {
            return regionid;
        }

        public void setRegionid(String regionid) {
            this.regionid = regionid;
        }

        public String getMarketnm() {
            return marketnm;
        }

        public void setMarketnm(String marketnm) {
            this.marketnm = marketnm;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getYyzz() {
            return yyzz;
        }

        public void setYyzz(String yyzz) {
            this.yyzz = yyzz;
        }

        public String getRen() {
            return ren;
        }

        public void setRen(String ren) {
            this.ren = ren;
        }

        public String getZhuren() {
            return zhuren;
        }

        public void setZhuren(String zhuren) {
            this.zhuren = zhuren;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(regionid);
            dest.writeString(marketnm);
            dest.writeString(tel);
            dest.writeString(address);
            dest.writeString(yyzz);
            dest.writeString(ren);
            dest.writeString(zhuren);
            dest.writeString(phone);
            dest.writeString(beifen);
            dest.writeString(mark);
            dest.writeString(mbrk);
            dest.writeString(mcrk);
            dest.writeString(remark);
        }
    }
}
