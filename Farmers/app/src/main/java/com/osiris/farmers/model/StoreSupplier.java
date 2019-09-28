package com.osiris.farmers.model;

import java.util.List;

public class StoreSupplier {


    /**
     * code : null
     * count : 2
     * msg : ok
     * customer : [{"id":1,"customernm":"1111111","userid":"22222222","type":"3333333","lianxir":"344444445","address":"566666666","phone":"55555555","commoditynm":"7777777777777","beifen":"27","mark":"","mbrk":"","mcrk":"","remark":""},{"id":4,"customernm":"1234","userid":"test","type":"23","lianxir":"ashin","address":"ooooo","phone":"13299990393993","commoditynm":"eqweqeq","beifen":"27","mark":"","mbrk":"","mcrk":"","remark":""}]
     */

    private Object code;
    private String count;
    private String msg;
    private List<CustomerBean> customer;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
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

    public List<CustomerBean> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerBean> customer) {
        this.customer = customer;
    }

    public static class CustomerBean {
        /**
         * id : 1
         * customernm : 1111111
         * userid : 22222222
         * type : 3333333
         * lianxir : 344444445
         * address : 566666666
         * phone : 55555555
         * commoditynm : 7777777777777
         * beifen : 27
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         */

        private int id;
        private String customernm;
        private String userid;
        private String type;
        private String lianxir;
        private String address;
        private String phone;
        private String commoditynm;
        private String beifen;
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

        public String getCustomernm() {
            return customernm;
        }

        public void setCustomernm(String customernm) {
            this.customernm = customernm;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLianxir() {
            return lianxir;
        }

        public void setLianxir(String lianxir) {
            this.lianxir = lianxir;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCommoditynm() {
            return commoditynm;
        }

        public void setCommoditynm(String commoditynm) {
            this.commoditynm = commoditynm;
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
    }
}
