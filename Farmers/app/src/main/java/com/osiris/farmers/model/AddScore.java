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
    private List<PingjiaxxsBean> pingjiaxxs;
    private List<ZhanghglsBean> zhanghgls;

    public List<PingjiaxxsBean> getPingjiaxxs() {
        return pingjiaxxs;
    }

    public void setPingjiaxxs(List<PingjiaxxsBean> pingjiaxxs) {
        this.pingjiaxxs = pingjiaxxs;
    }

    public List<ZhanghglsBean> getZhanghgls() {
        return zhanghgls;
    }

    public void setZhanghgls(List<ZhanghglsBean> zhanghgls) {
        this.zhanghgls = zhanghgls;
    }

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


    public static class PingjiaxxsBean {
        /**
         * id : 3
         * jyhid : 15
         * pingjianr : ddddddddddd1111111
         * pingjiaxj :
         * marketid : 1
         * marketnm : 新桥菜市场
         * tsremark :
         * llrq : 2019-10-23 08:54:32
         * mark :
         * mbrk :
         * mcrk :
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

    public static class ZhanghglsBean {
        /**
         * id : 50
         * xuhao : null
         * loginId : jy111
         * jcyname : jy111
         * ssjg : 1
         * createtime : 2019-10-12 09:16:16
         * quanx : null
         * mark : null
         * mbrk : 经营户
         * mcrk : 21
         * remark : null
         * biyeschool : null
         * zhuanye : null
         * ruzhitime : null
         * zhaopian : null
         * biyezs : null
         * jingzs : null
         * sheng : null
         * shi : 1
         * region : null
         * jiedao : null
         * market : null
         * type : null
         */

        private int id;
        private Object xuhao;
        private String loginId;
        private String jcyname;
        private String ssjg;
        private String createtime;
        private Object quanx;
        private Object mark;
        private String mbrk;
        private String mcrk;
        private Object remark;
        private Object biyeschool;
        private Object zhuanye;
        private Object ruzhitime;
        private Object zhaopian;
        private Object biyezs;
        private Object jingzs;
        private Object sheng;
        private String shi;
        private Object region;
        private Object jiedao;
        private Object market;
        private Object type;
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

        public Object getXuhao() {
            return xuhao;
        }

        public void setXuhao(Object xuhao) {
            this.xuhao = xuhao;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getJcyname() {
            return jcyname;
        }

        public void setJcyname(String jcyname) {
            this.jcyname = jcyname;
        }

        public String getSsjg() {
            return ssjg;
        }

        public void setSsjg(String ssjg) {
            this.ssjg = ssjg;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getQuanx() {
            return quanx;
        }

        public void setQuanx(Object quanx) {
            this.quanx = quanx;
        }

        public Object getMark() {
            return mark;
        }

        public void setMark(Object mark) {
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

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getBiyeschool() {
            return biyeschool;
        }

        public void setBiyeschool(Object biyeschool) {
            this.biyeschool = biyeschool;
        }

        public Object getZhuanye() {
            return zhuanye;
        }

        public void setZhuanye(Object zhuanye) {
            this.zhuanye = zhuanye;
        }

        public Object getRuzhitime() {
            return ruzhitime;
        }

        public void setRuzhitime(Object ruzhitime) {
            this.ruzhitime = ruzhitime;
        }

        public Object getZhaopian() {
            return zhaopian;
        }

        public void setZhaopian(Object zhaopian) {
            this.zhaopian = zhaopian;
        }

        public Object getBiyezs() {
            return biyezs;
        }

        public void setBiyezs(Object biyezs) {
            this.biyezs = biyezs;
        }

        public Object getJingzs() {
            return jingzs;
        }

        public void setJingzs(Object jingzs) {
            this.jingzs = jingzs;
        }

        public Object getSheng() {
            return sheng;
        }

        public void setSheng(Object sheng) {
            this.sheng = sheng;
        }

        public String getShi() {
            return shi;
        }

        public void setShi(String shi) {
            this.shi = shi;
        }

        public Object getRegion() {
            return region;
        }

        public void setRegion(Object region) {
            this.region = region;
        }

        public Object getJiedao() {
            return jiedao;
        }

        public void setJiedao(Object jiedao) {
            this.jiedao = jiedao;
        }

        public Object getMarket() {
            return market;
        }

        public void setMarket(Object market) {
            this.market = market;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }
    }
}
