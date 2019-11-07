package com.osiris.farmers.model;

import java.util.List;

public class EvaluateDetail {


    /**
     * marketnm : 学田菜市场
     * region : 崇川区
     * jiedao : null
     * username : 监管部门测试111
     * jyh : null
     * pingjiaxxs : [{"id":112,"jyhid":"1","pingjianr":"jjkjkkj","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-10-15 11:09:40","mark":"","mbrk":"2","mcrk":"差","remark":""},{"id":113,"jyhid":"1","pingjianr":"1","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-10-15 11:09:56","mark":"","mbrk":"3","mcrk":"一般","remark":""},{"id":114,"jyhid":"1","pingjianr":"jkjjk","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-10-15 11:10:02","mark":"","mbrk":"1","mcrk":"极差","remark":""},{"id":8,"jyhid":"15","pingjianr":"ddddddddddddd","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-09-25 13:41:35","mark":"","mbrk":"2","mcrk":"差","remark":""},{"id":9,"jyhid":"15","pingjianr":"gggggggggggg2222222222","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-09-25 15:51:28","mark":"","mbrk":"4","mcrk":"满意","remark":""},{"id":3,"jyhid":"15","pingjianr":"ddddddddddd","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-09-25 13:41:22","mark":"","mbrk":"3","mcrk":"一般","remark":""},{"id":4,"jyhid":"15","pingjianr":"dddddddddd","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-09-25 13:41:24","mark":"","mbrk":"4","mcrk":"满意","remark":""},{"id":39,"jyhid":"1","pingjianr":"deeeeeeee","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-10-14 09:17:58","mark":"","mbrk":"3","mcrk":"一般","remark":""},{"id":40,"jyhid":"1","pingjianr":"ewwwwwww","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-10-14 09:19:48","mark":"","mbrk":"3","mcrk":"一般","remark":""}]
     */

    private String marketnm;
    private String region;
    private Object jiedao;
    private String username;
    private Object jyh;
    private List<PingjiaxxsBean> pingjiaxxs;

    public String getMarketnm() {
        return marketnm;
    }

    public void setMarketnm(String marketnm) {
        this.marketnm = marketnm;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Object getJiedao() {
        return jiedao;
    }

    public void setJiedao(Object jiedao) {
        this.jiedao = jiedao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getJyh() {
        return jyh;
    }

    public void setJyh(Object jyh) {
        this.jyh = jyh;
    }

    public List<PingjiaxxsBean> getPingjiaxxs() {
        return pingjiaxxs;
    }

    public void setPingjiaxxs(List<PingjiaxxsBean> pingjiaxxs) {
        this.pingjiaxxs = pingjiaxxs;
    }

    public static class PingjiaxxsBean {
        /**
         * id : 112
         * jyhid : 1
         * pingjianr : jjkjkkj
         * pingjiaxj :
         * marketid : 0
         * marketnm : 总管理员
         * tsremark :
         * llrq : 2019-10-15 11:09:40
         * mark :
         * mbrk : 2
         * mcrk : 差
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
