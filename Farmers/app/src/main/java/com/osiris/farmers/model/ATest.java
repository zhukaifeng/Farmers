package com.osiris.farmers.model;

import java.util.List;

public class ATest {


    /**
     * pd : null
     * num : 1
     * zhugpingjias : [{"id":66,"jyhid":"7","pingjianr":"2|差|15,3|一般|23,4|满意|24,5|非常满意|70","pingjiaxj":"江苏省","marketid":"","marketnm":"城中菜市场","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-20 23:12:02","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":50,"jyhid":"1","pingjianr":"2|差|15,2|差|23,2|差|24,4|满意|70","pingjiaxj":"江苏省","marketid":"","marketnm":"新桥菜市场","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-18 22:24:31","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":47,"jyhid":"1","pingjianr":"2|差|112,4|满意|113","pingjiaxj":"江苏省","marketid":"","marketnm":"新桥菜市场","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-18 10:22:33","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""}]
     * zhugjyhpingjias : [{"id":14,"jyhid":"163","pingjianr":"2|差|13,3|一般|15,4|满意|23,3|一般|24","pingjiaxj":"江苏省","marketid":"","marketnm":"阎绍雨","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-18 22:23:24","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":18,"jyhid":"163","pingjianr":"3|一般|13,4|满意|15,5|非常满意|23,3|一般|24","pingjiaxj":"江苏省","marketid":"","marketnm":"阎绍雨","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-20 22:37:48","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":19,"jyhid":"163","pingjianr":"3|一般|13,5|非常满意|15,5|非常满意|23,2|差|24","pingjiaxj":"江苏省","marketid":"","marketnm":"阎绍雨","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-20 22:41:19","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":22,"jyhid":"165","pingjianr":"3|一般|13,5|非常满意|15,4|满意|23,3|一般|24","pingjiaxj":"江苏省","marketid":"","marketnm":"张洪生","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-20 22:50:15","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""},{"id":25,"jyhid":"169","pingjianr":"1|极差|13,2|差|15,3|一般|23,4|满意|24","pingjiaxj":"江苏省","marketid":"","marketnm":"王友平","tsremark":"129","userid":"崇川区市场监督局","username":null,"llrq":"2020-02-20 23:12:25","mark":"","mbrk":"崇川区","mcrk":"南通市","remark":""}]
     */

    private Object pd;
    private String num;
    private List<ZhugpingjiasBean> zhugpingjias;
    private List<ZhugjyhpingjiasBean> zhugjyhpingjias;

    public Object getPd() {
        return pd;
    }

    public void setPd(Object pd) {
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

    public List<ZhugjyhpingjiasBean> getZhugjyhpingjias() {
        return zhugjyhpingjias;
    }

    public void setZhugjyhpingjias(List<ZhugjyhpingjiasBean> zhugjyhpingjias) {
        this.zhugjyhpingjias = zhugjyhpingjias;
    }

    public static class ZhugpingjiasBean {
        /**
         * id : 66
         * jyhid : 7
         * pingjianr : 2|差|15,3|一般|23,4|满意|24,5|非常满意|70
         * pingjiaxj : 江苏省
         * marketid :
         * marketnm : 城中菜市场
         * tsremark : 129
         * userid : 崇川区市场监督局
         * username : null
         * llrq : 2020-02-20 23:12:02
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

    public static class ZhugjyhpingjiasBean {
        /**
         * id : 14
         * jyhid : 163
         * pingjianr : 2|差|13,3|一般|15,4|满意|23,3|一般|24
         * pingjiaxj : 江苏省
         * marketid :
         * marketnm : 阎绍雨
         * tsremark : 129
         * userid : 崇川区市场监督局
         * username : null
         * llrq : 2020-02-18 22:23:24
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
