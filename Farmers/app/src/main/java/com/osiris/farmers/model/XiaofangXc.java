package com.osiris.farmers.model;

import java.util.List;

public class XiaofangXc {


    /**
     * result : 0
     * message : 1
     * data : [{"id":1,"titleMsg":"1","xiaofangdwId":"1","xiaofangdwName":"1","tupian":"1111.png","upTime":"2020-02-18 00:00:00","resultMsg":null,"userId":"53","marketId":"20","marketName":"观音山新城菜市场"},{"id":3,"titleMsg":"3","xiaofangdwId":"1","xiaofangdwName":"1","tupian":"3333.png","upTime":"2020-02-18 00:00:00","resultMsg":null,"userId":"58","marketId":"20","marketName":"观音山新城菜市场"}]
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
         * id : 1
         * titleMsg : 1
         * xiaofangdwId : 1
         * xiaofangdwName : 1
         * tupian : 1111.png
         * upTime : 2020-02-18 00:00:00
         * resultMsg : null
         * userId : 53
         * marketId : 20
         * marketName : 观音山新城菜市场
         */

        private int id;
        private String titleMsg;
        private String xiaofangdwId;
        private String xiaofangdwName;
        private String tupian;
        private String upTime;
        private String resultMsg;
        private String userId;
        private String marketId;
        private String marketName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitleMsg() {
            return titleMsg;
        }

        public void setTitleMsg(String titleMsg) {
            this.titleMsg = titleMsg;
        }

        public String getXiaofangdwId() {
            return xiaofangdwId;
        }

        public void setXiaofangdwId(String xiaofangdwId) {
            this.xiaofangdwId = xiaofangdwId;
        }

        public String getXiaofangdwName() {
            return xiaofangdwName;
        }

        public void setXiaofangdwName(String xiaofangdwName) {
            this.xiaofangdwName = xiaofangdwName;
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

        public String getMarketName() {
            return marketName;
        }

        public void setMarketName(String marketName) {
            this.marketName = marketName;
        }
    }
}
