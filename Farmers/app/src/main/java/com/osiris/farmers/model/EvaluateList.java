package com.osiris.farmers.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class EvaluateList {


    /**
     * pd : 1
     * num : 1
     * zhugpingjias : [{"id":3,"jyhid":"17","pingjianr":"2|差|112,3|一般|113,1|极差|114,2|差|8,4|满意|9,3|一般|3,4|满意|4,3|一般|39,3|一般|40","pingjiaxj":"江苏省","marketid":"","marketnm":"学田菜市场","tsremark":"59","userid":"监管部门测试111","username":null,"llrq":"2019-10-28 15:21:36","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":2,"jyhid":"2","pingjianr":"2|差|112,3|一般|113,4|满意|114,4|满意|8,3|一般|9","pingjiaxj":"江苏省","marketid":"","marketnm":"濠东菜市场","tsremark":"59","userid":"监管部门测试111","username":null,"llrq":"2019-10-25 09:15:18","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":1,"jyhid":"1","pingjianr":"2|差|112,3|一般|113,4|满意|114,2|差|8,3|一般|9","pingjiaxj":"江苏省","marketid":"","marketnm":"新桥菜市场","tsremark":"59","userid":"监管部门测试111","username":null,"llrq":"2019-10-25 09:15:08","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""}]
     * zhugjyhpingjias : []
     */

    private String pd;
    private String num;
    private List<ZhugpingjiasBean> zhugpingjias;
    private List<?> zhugjyhpingjias;

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<ZhugpingjiasBean> getZhugpingjias() {
        return zhugpingjias;
    }

    public void setZhugpingjias(List<ZhugpingjiasBean> zhugpingjias) {
        this.zhugpingjias = zhugpingjias;
    }

    public List<?> getZhugjyhpingjias() {
        return zhugjyhpingjias;
    }

    public void setZhugjyhpingjias(List<?> zhugjyhpingjias) {
        this.zhugjyhpingjias = zhugjyhpingjias;
    }

    public static class ZhugpingjiasBean implements Parcelable {
        /**
         * id : 3
         * jyhid : 17
         * pingjianr : 2|差|112,3|一般|113,1|极差|114,2|差|8,4|满意|9,3|一般|3,4|满意|4,3|一般|39,3|一般|40
         * pingjiaxj : 江苏省
         * marketid :
         * marketnm : 学田菜市场
         * tsremark : 59
         * userid : 监管部门测试111
         * username : null
         * llrq : 2019-10-28 15:21:36
         * mark :
         * mbrk : 崇川区
         * mcrk : 南通市
         * remark :
         */

        private int id;
        private String jyhid;
        private String pingjianr;
        private String pingjiaxj;
        private String marketid;
        private String marketnm;
        private String tsremark;
        private String userid;
        private Object username;
        private String llrq;
        private String mark;
        private String mbrk;
        private String mcrk;
        private String remark;

        protected ZhugpingjiasBean(Parcel in) {
            id = in.readInt();
            jyhid = in.readString();
            pingjianr = in.readString();
            pingjiaxj = in.readString();
            marketid = in.readString();
            marketnm = in.readString();
            tsremark = in.readString();
            userid = in.readString();
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
            dest.writeString(userid);
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

        public static final Creator<ZhugpingjiasBean> CREATOR = new Creator<ZhugpingjiasBean>() {
            @Override
            public ZhugpingjiasBean createFromParcel(Parcel in) {
                return new ZhugpingjiasBean(in);
            }

            @Override
            public ZhugpingjiasBean[] newArray(int size) {
                return new ZhugpingjiasBean[size];
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

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
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
}
