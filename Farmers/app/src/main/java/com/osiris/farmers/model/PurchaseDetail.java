package com.osiris.farmers.model;

public class PurchaseDetail {


    /**
     * result : 0
     * message : 1
     * data : {"id":9,"splb":"大白菜","spbm":"蔬菜及蔬菜制品","spmc":"","danwei":"","sptm":"","dh":"客户编号1111","riqi":"100","sum":"0","spdj":"22","sphj":"2200","scriqi":"28","rkcangku":"20","gongys":"163","hycompany":"2020-02-20","hydh":"22222","yunfei":"","gldh":"","llrq":"2020-02-21 21:30:58","mark":"","mbrk":"","mcrk":"","remark":""}
     */

    private int result;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 9
         * splb : 大白菜
         * spbm : 蔬菜及蔬菜制品
         * spmc :
         * danwei :
         * sptm :
         * dh : 客户编号1111
         * riqi : 100
         * sum : 0
         * spdj : 22
         * sphj : 2200
         * scriqi : 28
         * rkcangku : 20
         * gongys : 163
         * hycompany : 2020-02-20
         * hydh : 22222
         * yunfei :
         * gldh :
         * llrq : 2020-02-21 21:30:58
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         */

        private int id;
        private String splb;
        private String spbm;
        private String spmc;
        private String danwei;
        private String sptm;
        private String dh;
        private String riqi;
        private String sum;
        private String spdj;
        private String sphj;
        private String scriqi;
        private String rkcangku;
        private String gongys;
        private String hycompany;
        private String hydh;
        private String yunfei;
        private String gldh;
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

        public String getSplb() {
            return splb;
        }

        public void setSplb(String splb) {
            this.splb = splb;
        }

        public String getSpbm() {
            return spbm;
        }

        public void setSpbm(String spbm) {
            this.spbm = spbm;
        }

        public String getSpmc() {
            return spmc;
        }

        public void setSpmc(String spmc) {
            this.spmc = spmc;
        }

        public String getDanwei() {
            return danwei;
        }

        public void setDanwei(String danwei) {
            this.danwei = danwei;
        }

        public String getSptm() {
            return sptm;
        }

        public void setSptm(String sptm) {
            this.sptm = sptm;
        }

        public String getDh() {
            return dh;
        }

        public void setDh(String dh) {
            this.dh = dh;
        }

        public String getRiqi() {
            return riqi;
        }

        public void setRiqi(String riqi) {
            this.riqi = riqi;
        }

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public String getSpdj() {
            return spdj;
        }

        public void setSpdj(String spdj) {
            this.spdj = spdj;
        }

        public String getSphj() {
            return sphj;
        }

        public void setSphj(String sphj) {
            this.sphj = sphj;
        }

        public String getScriqi() {
            return scriqi;
        }

        public void setScriqi(String scriqi) {
            this.scriqi = scriqi;
        }

        public String getRkcangku() {
            return rkcangku;
        }

        public void setRkcangku(String rkcangku) {
            this.rkcangku = rkcangku;
        }

        public String getGongys() {
            return gongys;
        }

        public void setGongys(String gongys) {
            this.gongys = gongys;
        }

        public String getHycompany() {
            return hycompany;
        }

        public void setHycompany(String hycompany) {
            this.hycompany = hycompany;
        }

        public String getHydh() {
            return hydh;
        }

        public void setHydh(String hydh) {
            this.hydh = hydh;
        }

        public String getYunfei() {
            return yunfei;
        }

        public void setYunfei(String yunfei) {
            this.yunfei = yunfei;
        }

        public String getGldh() {
            return gldh;
        }

        public void setGldh(String gldh) {
            this.gldh = gldh;
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
