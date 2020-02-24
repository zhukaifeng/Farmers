package com.osiris.farmers.model;

import java.util.List;

public class MarketCheck {


    /**
     * result : 0
     * message : 1
     * pageNum : 2
     * data : [{"id":1,"tupian":"tupain.png","upTime":"2020-02-17 00:00:00","resultMsg":"结果","userId":"59","marketId":"18","marketName":null},{"id":2,"tupian":"2","upTime":"2020-02-17 23:06:606","resultMsg":"jieguo","userId":"59","marketId":"18","marketName":null}]
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
         * id : 1
         * tupian : tupain.png
         * upTime : 2020-02-17 00:00:00
         * resultMsg : 结果
         * userId : 59
         * marketId : 18
         * marketName : null
         */

        private int id;
        private String tupian;
        private String upTime;
        private String resultMsg;
        private String userId;
        private String marketId;
        private Object marketName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTupian() {
            return tupian;
        }

        public void setTupian(String tupian) {
            this.tupian = tupian;
        }

        public String getUpTime() {
            return upTime;
        }

        public void setUpTime(String upTime) {
            this.upTime = upTime;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMarketId() {
            return marketId;
        }

        public void setMarketId(String marketId) {
            this.marketId = marketId;
        }

        public Object getMarketName() {
            return marketName;
        }

        public void setMarketName(Object marketName) {
            this.marketName = marketName;
        }
    }
}
