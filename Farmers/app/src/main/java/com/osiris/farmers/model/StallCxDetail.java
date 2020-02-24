package com.osiris.farmers.model;

public class StallCxDetail {


    /**
     * result : 0
     * message : 1
     * data : {"id":4,"jyhid":"65","jyhmc":"阎绍雨","twhma":"108","twhmc":"蔬菜01","user":"","phone":"","quyu":"蔬菜区","mianji":"9㎡","money":"1000","louceng":"一楼","marketid":20,"marketnm":"观音山新城菜市场","tsremark":"jyhht001.jpg,jyhht002.jpg,jyhht003.jpg,jyhht004.jpg","llrq":"2019-12-16 17:41:07","mark":"","mbrk":"","mcrk":"","remark":""}
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
         * id : 4
         * jyhid : 65
         * jyhmc : 阎绍雨
         * twhma : 108
         * twhmc : 蔬菜01
         * user :
         * phone :
         * quyu : 蔬菜区
         * mianji : 9㎡
         * money : 1000
         * louceng : 一楼
         * marketid : 20
         * marketnm : 观音山新城菜市场
         * tsremark : jyhht001.jpg,jyhht002.jpg,jyhht003.jpg,jyhht004.jpg
         * llrq : 2019-12-16 17:41:07
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         */

        private int id;
        private String jyhid;
        private String jyhmc;
        private String twhma;
        private String twhmc;
        private String user;
        private String phone;
        private String quyu;
        private String mianji;
        private String money;
        private String louceng;
        private int marketid;
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

        public String getJyhmc() {
            return jyhmc;
        }

        public void setJyhmc(String jyhmc) {
            this.jyhmc = jyhmc;
        }

        public String getTwhma() {
            return twhma;
        }

        public void setTwhma(String twhma) {
            this.twhma = twhma;
        }

        public String getTwhmc() {
            return twhmc;
        }

        public void setTwhmc(String twhmc) {
            this.twhmc = twhmc;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getQuyu() {
            return quyu;
        }

        public void setQuyu(String quyu) {
            this.quyu = quyu;
        }

        public String getMianji() {
            return mianji;
        }

        public void setMianji(String mianji) {
            this.mianji = mianji;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getLouceng() {
            return louceng;
        }

        public void setLouceng(String louceng) {
            this.louceng = louceng;
        }

        public int getMarketid() {
            return marketid;
        }

        public void setMarketid(int marketid) {
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
