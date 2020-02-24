package com.osiris.farmers.model;

import java.util.List;

public class ManagerData1 {


    /**
     * result : 0
     * message : 1
     * pageNum : 1
     * data : [{"id":14,"zlkmc":"食品生产许可分类目录公告（2016年第23号）","jtnr":"1576573109790.pdf","leibie":"2","scsj":"2016-01-22","mark":"2016-01-22","mbrk":"国家食品药品监督管理总局","mcrk":null,"remark":"食品生产许可分类目录.pdf"},{"id":13,"zlkmc":"食品中污染物限量（GB2762-2017）","jtnr":"1576572462923.pdf","leibie":"2","scsj":"2017-03-17","mark":"2017-09-17","mbrk":"中华人名共和国国家卫生和计划生育委员会、国家食品药品监督管理总局","mcrk":null,"remark":"GB2762-2017.pdf"},{"id":12,"zlkmc":"食品中真菌毒素限量（GB2761-2017)","jtnr":"1576572326970.pdf","leibie":"2","scsj":"2017-03-17","mark":"2017-09-17","mbrk":"中华人名共和国国家卫生和计划生育委员会","mcrk":null,"remark":"GB2761-2017.pdf"},{"id":4,"zlkmc":"食品中农药最大残留限量（GB2763-2016）","jtnr":"1576231371525.pdf","leibie":"2","scsj":"2016-12-18","mark":"2017-06-18","mbrk":"中华人名共和国国家卫生和计划生育委员会","mcrk":null,"remark":"GB 2763-2016 食品中农药最大残留限量.pdf"},{"id":3,"zlkmc":"食品添加剂使用标准（GB2760-2014)","jtnr":"1576231196665.pdf","leibie":"2","scsj":"2014-12-24","mark":"2015-05-24","mbrk":"中华人名共和国国家卫生和计划生育委员会","mcrk":null,"remark":"GB 2760-2014 食品安全国家标准 食品添加剂使用标准.pdf"},{"id":1,"zlkmc":"食品安全监督抽检和风险监测实施细则（2015年版）","jtnr":"1576230575079.pdf","leibie":"2","scsj":"2015-03-03","mark":"2015-03-03","mbrk":"食品药品监管总局办公厅","mcrk":null,"remark":"《食品安全监督抽检和风险监测实施细则》(2015年版).pdf"}]
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
         * id : 14
         * zlkmc : 食品生产许可分类目录公告（2016年第23号）
         * jtnr : 1576573109790.pdf
         * leibie : 2
         * scsj : 2016-01-22
         * mark : 2016-01-22
         * mbrk : 国家食品药品监督管理总局
         * mcrk : null
         * remark : 食品生产许可分类目录.pdf
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
