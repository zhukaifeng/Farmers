package com.osiris.farmers.model;

import java.util.List;

public class ScoreDetailShichang {


    /**
     * pingjiaxxs : [{"id":13,"jyhid":"15","pingjianr":"证照齐全，按核准的登记事项从事经营活动。","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-11-27 15:22:56","mark":"","mbrk":"3","mcrk":"一般","remark":""},{"id":15,"jyhid":"15","pingjianr":"亮照经营，营业执照按规定悬挂。","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-11-27 15:24:13","mark":"","mbrk":"4","mcrk":"满意","remark":""}]
     * marketpingjia : {"id":43,"jyhid":"164","pingjianr":"3|一般|13,4|满意|15","pingjiaxj":"","marketid":"20","marketnm":"观音山新城菜市场","tsremark":"53","userid":null,"username":"刘小琪","llrq":"2020-02-20 20:24:31","mark":"","mbrk":"","mcrk":"张袁葛","remark":""}
     * zhanghgls : null
     */

    private MarketpingjiaBean marketpingjia;
    private Object zhanghgls;
    private List<PingjiaxxsBean> pingjiaxxs;

    public MarketpingjiaBean getMarketpingjia() {
        return marketpingjia;
    }

    public void setMarketpingjia(MarketpingjiaBean marketpingjia) {
        this.marketpingjia = marketpingjia;
    }

    public Object getZhanghgls() {
        return zhanghgls;
    }

    public void setZhanghgls(Object zhanghgls) {
        this.zhanghgls = zhanghgls;
    }

    public List<PingjiaxxsBean> getPingjiaxxs() {
        return pingjiaxxs;
    }

    public void setPingjiaxxs(List<PingjiaxxsBean> pingjiaxxs) {
        this.pingjiaxxs = pingjiaxxs;
    }

    public static class MarketpingjiaBean {
        /**
         * id : 43
         * jyhid : 164
         * pingjianr : 3|一般|13,4|满意|15
         * pingjiaxj :
         * marketid : 20
         * marketnm : 观音山新城菜市场
         * tsremark : 53
         * userid : null
         * username : 刘小琪
         * llrq : 2020-02-20 20:24:31
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
    }

    public static class PingjiaxxsBean {
        /**
         * id : 13
         * jyhid : 15
         * pingjianr : 证照齐全，按核准的登记事项从事经营活动。
         * pingjiaxj :
         * marketid : 1
         * marketnm : 新桥菜市场
         * tsremark :
         * llrq : 2019-11-27 15:22:56
         * mark :
         * mbrk : 3
         * mcrk : 一般
         * remark :
         */

        private int id;
        private String jyhid;
        private String pingjianr;
        private String pingjiaxj;
        private String marketid;
        private String marketnm;
        private String tsremark;
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
