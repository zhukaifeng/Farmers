package com.osiris.farmers.model;

import java.util.List;

public class Rules {


    /**
     * result : 0
     * message : 1
     * pageNum : 2
     * data : [{"id":11,"zlkmc":"食用农产品快速检测项目","jtnr":"1576570552064.pdf","leibie":"3","scsj":"2016-12-16","mark":"2016-12-16","mbrk":"江苏广诚食品安全检测有限公司","mcrk":null,"remark":"农贸市场食用农产品快检检查项目.pdf"},{"id":10,"zlkmc":"不合格食用农产品处置制度","jtnr":"1576570476306.pdf","leibie":"3","scsj":"2016-12-16","mark":"2016-12-16","mbrk":"江苏广诚食品安全检测有限公司","mcrk":null,"remark":"不合格食用农产品处置制度.pdf"},{"id":9,"zlkmc":"检测室管理制度","jtnr":"1576570370540.pdf","leibie":"3","scsj":"2016-12-16","mark":"2016-12-17","mbrk":"江苏广诚食品安全检测有限公司","mcrk":null,"remark":"检测室管理制度.pdf"},{"id":8,"zlkmc":"检测室工作流程","jtnr":"1576570154407.pdf","leibie":"3","scsj":"2016-12-16","mark":"2016-12-16","mbrk":"江苏广诚食品安全检测有限公司","mcrk":null,"remark":"检测室工作流程.pdf"},{"id":7,"zlkmc":"检测室工作人员职责","jtnr":"1576570386032.pdf","leibie":"3","scsj":"2016-12-16","mark":"2016-12-16","mbrk":"江苏广诚食品安全检测有限公司","mcrk":null,"remark":"检测室工作人员职责.pdf"}]
     */

    private int result;
    private String message;
    private int pageNum;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11
         * zlkmc : 食用农产品快速检测项目
         * jtnr : 1576570552064.pdf
         * leibie : 3
         * scsj : 2016-12-16
         * mark : 2016-12-16
         * mbrk : 江苏广诚食品安全检测有限公司
         * mcrk : null
         * remark : 农贸市场食用农产品快检检查项目.pdf
         */

        private int id;
        private String zlkmc;
        private String jtnr;
        private String leibie;
        private String scsj;
        private String mark;
        private String mbrk;
        private Object mcrk;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getZlkmc() {
            return zlkmc;
        }

        public void setZlkmc(String zlkmc) {
            this.zlkmc = zlkmc;
        }

        public String getJtnr() {
            return jtnr;
        }

        public void setJtnr(String jtnr) {
            this.jtnr = jtnr;
        }

        public String getLeibie() {
            return leibie;
        }

        public void setLeibie(String leibie) {
            this.leibie = leibie;
        }

        public String getScsj() {
            return scsj;
        }

        public void setScsj(String scsj) {
            this.scsj = scsj;
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

        public Object getMcrk() {
            return mcrk;
        }

        public void setMcrk(Object mcrk) {
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
