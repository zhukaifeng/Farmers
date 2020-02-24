package com.osiris.farmers.model;

import java.util.List;

public class AddScore {


    /**
     * type : 1
     * markets : [{"id":1,"regionid":"1","marketnm":"新桥菜市场","tel":"18962993668","address":"新桥商业区1号楼西边","yyzz":"91321182058664862T","ren":"李苏","zhuren":"李苏","phone":"18962993668","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":2,"regionid":"1","marketnm":"濠东菜市场","tel":"13962967779","address":"濠东新村商业区","yyzz":"91321182MA1NFY5Q9A","ren":"陈辉","zhuren":"陈辉","phone":"13962967779","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":3,"regionid":"1","marketnm":"东方菜市场","tel":"13806298388","address":"人民路68号","yyzz":"91321182703960972J","ren":"陈志刚","zhuren":"陈志刚","phone":"13806298388","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":4,"regionid":"2","marketnm":"观音山菜市场","tel":"13951321655","address":"观音山太平北路366号","yyzz":"91321100MA1P212U30","ren":"王建","zhuren":"王建","phone":"13951321655","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":5,"regionid":"3","marketnm":"北濠桥菜市场","tel":"13773667219","address":"濠北路193号","yyzz":"91321100MA1P210L77","ren":"顾杨","zhuren":"顾杨","phone":"13773667219","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":6,"regionid":"3","marketnm":"端平桥菜市场","tel":"13862928885","address":"人民中路204号#8号","yyzz":"321182000088204","ren":"张钰","zhuren":"张钰","phone":"13862928885","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":7,"regionid":"3","marketnm":"城中菜市场","tel":"13806295776","address":"人民路北、北濠桥路东，南通大厦D座101室","yyzz":"321182000086080","ren":"徐旭","zhuren":"徐旭","phone":"13806295776","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":8,"regionid":"4","marketnm":"都市华城菜市场","tel":"18906297001","address":"任港路39号","yyzz":"321124197605140019","ren":"冯主任","zhuren":"冯主任","phone":"18906297001","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":9,"regionid":"4","marketnm":"虹桥菜市场","tel":"13806295659","address":"虹桥新村内商业1号楼","yyzz":"321182000006179","ren":"周翠珍","zhuren":"周翠珍","phone":"13806295659","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":10,"regionid":"4","marketnm":"莘园路菜市场","tel":"13962918479","address":"桃坞路89号","yyzz":"91321182MA1NXGQK2J","ren":"庄主任","zhuren":"庄主任","phone":"13962918479","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":11,"regionid":"5","marketnm":"五山菜市场","tel":"13901482191","address":"花园路北五山公寓旁","yyzz":"91321182MA1NTA3B4N","ren":"倪汉清","zhuren":"倪汉清","phone":"13901482191","beifen":"民营","mark":"","mbrk":"","mcrk":"","remark":""},{"id":12,"regionid":"6","marketnm":"城港菜市场","tel":"13515200232","address":"城港新村70号楼底楼","yyzz":"913321182MAIPYLY43F","ren":"陈峰","zhuren":"陈峰","phone":"13515200232","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""},{"id":13,"regionid":"7","marketnm":"天都菜市场","tel":"13862950160","address":"天都新村内沿河路北","yyzz":"913321182MAIPYLWU3U","ren":"陈主任","zhuren":"陈主任","phone":"13862950160","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""},{"id":14,"regionid":"7","marketnm":"长风菜市场","tel":"13861902368","address":"教育路45号","yyzz":"91321182MA1PD44F1R","ren":"常小荣","zhuren":"常小荣","phone":"13861902368","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""},{"id":15,"regionid":"8","marketnm":"易家桥菜市场","tel":"13016767977","address":"易家桥新村内工商路旁","yyzz":"321182000006179","ren":"徐冰","zhuren":"徐冰","phone":"13016767977","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":16,"regionid":"8","marketnm":"段家坝菜市场","tel":"18006290929","address":"段家坝路101号","yyzz":"321182000006180","ren":"周霆","zhuren":"周霆","phone":"18006290929","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":17,"regionid":"9","marketnm":"学田菜市场","tel":"13338068211","address":"学田新村内学田南路北","yyzz":"321182000006188","ren":"陈刚","zhuren":"陈刚","phone":"13338068211","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""},{"id":18,"regionid":"10","marketnm":"百花菜市场","tel":"15962990001","address":"百花村4组，钟秀路北濠西路东","yyzz":"321182000006184","ren":"单张","zhuren":"单张","phone":"15962990001","beifen":"集体","mark":"","mbrk":"","mcrk":"","remark":""},{"id":20,"regionid":"2","marketnm":"观音山新城菜市场","tel":"0513-89079342","address":"世纪大道盘香路交叉路口，中南世纪花城二期东北角","yyzz":"91320602MA1Q0K2U53","ren":"戴丽萍","zhuren":"戴丽萍","phone":"13773610590","beifen":"国有","mark":"","mbrk":"","mcrk":"","remark":""}]
     * pingjiaxxs : [{"id":15,"jyhid":"15","pingjianr":"亮照经营，营业执照按规定悬挂。","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-11-27 15:24:13","mark":"","mbrk":"","mcrk":"","remark":""},{"id":23,"jyhid":"15","pingjianr":"商品质量评价，保质保量，假冒伪劣，过期变质。","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-11-27 16:55:17","mark":"","mbrk":"","mcrk":"","remark":""},{"id":24,"jyhid":"15","pingjianr":"环境卫生","pingjiaxj":"","marketid":"1","marketnm":"新桥菜市场","tsremark":"","llrq":"2019-12-16 10:04:31","mark":"","mbrk":"","mcrk":"","remark":""},{"id":70,"jyhid":"1","pingjianr":"经营作风","pingjiaxj":"","marketid":"0","marketnm":"总管理员","tsremark":"","llrq":"2019-12-16 10:04:51","mark":"","mbrk":"","mcrk":"","remark":""}]
     * zhanghgls : []
     */

    private String type;
    private List<MarketsBean> markets;
    private List<PingjiaxxsBean> pingjiaxxs;
    private List<ZhanghglsBean> zhanghgls;

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

    public List<PingjiaxxsBean> getPingjiaxxs() {
        return pingjiaxxs;
    }

    public void setPingjiaxxs(List<PingjiaxxsBean> pingjiaxxs) {
        this.pingjiaxxs = pingjiaxxs;
    }


    public static class MarketsBean {
        /**
         * id : 1
         * regionid : 1
         * marketnm : 新桥菜市场
         * tel : 18962993668
         * address : 新桥商业区1号楼西边
         * yyzz : 91321182058664862T
         * ren : 李苏
         * zhuren : 李苏
         * phone : 18962993668
         * beifen : 国有
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

    public static class ZhanghglsBean {
        /**
         * id : 163
         * xuhao : null
         * loginId : 15106296172
         * jcyname : 阎绍雨
         * ssjg : 20
         * createtime : 2020-02-16 10:01:39
         * quanx : null
         * mark : null
         * mbrk : 经营户
         * mcrk : 23
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

    public static class PingjiaxxsBean {
        /**
         * id : 15
         * jyhid : 15
         * pingjianr : 亮照经营，营业执照按规定悬挂。
         * pingjiaxj :
         * marketid : 1
         * marketnm : 新桥菜市场
         * tsremark :
         * llrq : 2019-11-27 15:24:13
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
