package com.osiris.farmers.model;

import java.util.List;

public class SuyuanJinData {


    /**
     * result : 0
     * message : 1
     * data : [{"id":2,"splb":"小白菜","spbm":"蔬菜及蔬菜制品","spmc":"","danwei":"","sptm":"","dh":"1111111","riqi":"22","sum":"12","spdj":"3","sphj":"875","scriqi":"1","rkcangku":"18","gongys":"27","hycompany":"2019-09-10","hydh":"44444444444","yunfei":"","gldh":"","llrq":"2019-09-12 10:44:06","mark":"","mbrk":"","mcrk":"","remark":""}]
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

    public static class DataBean {
        /**
         * id : 2
         * splb : 小白菜
         * spbm : 蔬菜及蔬菜制品
         * spmc :
         * danwei :
         * sptm :
         * dh : 1111111
         * riqi : 22
         * sum : 12
         * spdj : 3
         * sphj : 875
         * scriqi : 1
         * rkcangku : 18
         * gongys : 27
         * hycompany : 2019-09-10
         * hydh : 44444444444
         * yunfei :
         * gldh :
         * llrq : 2019-09-12 10:44:06
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
