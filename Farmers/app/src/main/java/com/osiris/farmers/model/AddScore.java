package com.osiris.farmers.model;

import java.util.List;

public class AddScore {


    /**
     * type : 1
     * markets : [{"id":13,"regionid":"7","marketnm":"天都菜市场","tel":"13862950160","address":"天都新村内沿河路北","yyzz":"913321182MAIPYLWU3U","ren":"陈主任","zhuren":"陈主任","phone":"13862950160","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""},{"id":14,"regionid":"7","marketnm":"长风菜市场","tel":"13861902368","address":"教育路45号","yyzz":"91321182MA1PD44F1R","ren":"常小荣","zhuren":"常小荣","phone":"13861902368","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""}]
     * pingjiaxxs : []
     * zhanghgls : []
     */

    private String type;
    private List<MarketsBean> markets;
    private List<?> pingjiaxxs;
    private List<?> zhanghgls;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MarketsBean> getMarkets() {
        return markets;
    }

    public void setMarkets(List<MarketsBean> markets) {
        this.markets = markets;
    }

    public List<?> getPingjiaxxs() {
        return pingjiaxxs;
    }

    public void setPingjiaxxs(List<?> pingjiaxxs) {
        this.pingjiaxxs = pingjiaxxs;
    }

    public List<?> getZhanghgls() {
        return zhanghgls;
    }

    public void setZhanghgls(List<?> zhanghgls) {
        this.zhanghgls = zhanghgls;
    }

    public static class MarketsBean {
        /**
         * id : 13
         * regionid : 7
         * marketnm : 天都菜市场
         * tel : 13862950160
         * address : 天都新村内沿河路北
         * yyzz : 913321182MAIPYLWU3U
         * ren : 陈主任
         * zhuren : 陈主任
         * phone : 13862950160
         * beifen : 集体
         * mark :
         * mbrk :
         * mcrk :
         * remark :
         */

        private int id;
        private String regionid;
        private String marketnm;
        private String tel;
        private String address;
        private String yyzz;
        private String ren;
        private String zhuren;
        private String phone;
        private String beifen;
        private String mark;
        private String mbrk;
        private String mcrk;
        private String remark;
        private int score;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRegionid() {
            return regionid;
        }

        public void setRegionid(String regionid) {
            this.regionid = regionid;
        }

        public String getMarketnm() {
            return marketnm;
        }

        public void setMarketnm(String marketnm) {
            this.marketnm = marketnm;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getYyzz() {
            return yyzz;
        }

        public void setYyzz(String yyzz) {
            this.yyzz = yyzz;
        }

        public String getRen() {
            return ren;
        }

        public void setRen(String ren) {
            this.ren = ren;
        }

        public String getZhuren() {
            return zhuren;
        }

        public void setZhuren(String zhuren) {
            this.zhuren = zhuren;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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
