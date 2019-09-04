package com.osiris.farmers.model;

import java.util.List;

public class CheckProject {


    /**
     * code :
     * count :
     * jcxm : [{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":409,"jcmc":"克伦特罗","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"506","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":421,"jcmc":"莱克多巴胺","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"525","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":420,"jcmc":"沙丁胺醇","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"524","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":429,"jcmc":"喹诺酮类","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"533","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"0","byz":"","id":333,"jcmc":"重金属铅","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"80","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"0","byz":"","id":336,"jcmc":"重金属汞","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"83","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"0","byz":"","id":334,"jcmc":"重金属砷","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"81","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":434,"jcmc":"呋喃唑酮","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"538","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":433,"jcmc":"呋喃西林","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"537","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":431,"jcmc":"呋喃它酮","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"535","splbmc":"","spmc":"","spmcid":""},{"byd":"","byo":"","bys":"","byt":"3","byz":"","id":432,"jcmc":"呋喃妥因","llrq":"","mark":"","mbrk":"","mcrk":"","remark":"","splbid":"536","splbmc":"","spmc":"","spmcid":""}]
     * msg : 1
     * splbid :
     * splbnm :
     */

    private String code;
    private String count;
    private String msg;
    private String splbid;
    private String splbnm;
    private List<JcxmBean> jcxm;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSplbid() {
        return splbid;
    }

    public void setSplbid(String splbid) {
        this.splbid = splbid;
    }

    public String getSplbnm() {
        return splbnm;
    }

    public void setSplbnm(String splbnm) {
        this.splbnm = splbnm;
    }

    public List<JcxmBean> getJcxm() {
        return jcxm;
    }

    public void setJcxm(List<JcxmBean> jcxm) {
        this.jcxm = jcxm;
    }

    public static class JcxmBean {
        /**
         * byd :
         * byo :
         * bys :
         * byt : 3
         * byz :
         * id : 409
         * jcmc : 克伦特罗
         * llrq :
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         * splbid : 506
         * splbmc :
         * spmc :
         * spmcid :
         */

        private String byd;
        private String byo;
        private String bys;
        private String byt;
        private String byz;
        private int id;
        private String jcmc;
        private String llrq;
        private String mark;
        private String mbrk;
        private String mcrk;
        private String remark;
        private String splbid;
        private String splbmc;
        private String spmc;
        private String spmcid;
        private boolean select;

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }

        public String getByd() {
            return byd;
        }

        public void setByd(String byd) {
            this.byd = byd;
        }

        public String getByo() {
            return byo;
        }

        public void setByo(String byo) {
            this.byo = byo;
        }

        public String getBys() {
            return bys;
        }

        public void setBys(String bys) {
            this.bys = bys;
        }

        public String getByt() {
            return byt;
        }

        public void setByt(String byt) {
            this.byt = byt;
        }

        public String getByz() {
            return byz;
        }

        public void setByz(String byz) {
            this.byz = byz;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJcmc() {
            return jcmc;
        }

        public void setJcmc(String jcmc) {
            this.jcmc = jcmc;
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

        public String getSplbid() {
            return splbid;
        }

        public void setSplbid(String splbid) {
            this.splbid = splbid;
        }

        public String getSplbmc() {
            return splbmc;
        }

        public void setSplbmc(String splbmc) {
            this.splbmc = splbmc;
        }

        public String getSpmc() {
            return spmc;
        }

        public void setSpmc(String spmc) {
            this.spmc = spmc;
        }

        public String getSpmcid() {
            return spmcid;
        }

        public void setSpmcid(String spmcid) {
            this.spmcid = spmcid;
        }
    }
}
