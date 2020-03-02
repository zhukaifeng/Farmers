package com.osiris.farmers.model;

public class XingweiDetail {


    /**
     * result : 0
     * message : 1
     * data : {"id":11,"tupian":"","upTime":"2020-03-02 21:34:940","resultMsg":"1","userId":"53","marketId":"20","marketName":"观音山新城菜市场","authority":"市场管理","zlkId":"11","zlkMc":"食用农产品快速检测项目"}
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
         * id : 11
         * tupian :
         * upTime : 2020-03-02 21:34:940
         * resultMsg : 1
         * userId : 53
         * marketId : 20
         * marketName : 观音山新城菜市场
         * authority : 市场管理
         * zlkId : 11
         * zlkMc : 食用农产品快速检测项目
         */

        private int id;
        private String tupian;
        private String upTime;
        private String resultMsg;
        private String userId;
        private String marketId;
        private String marketName;
        private String authority;
        private String zlkId;
        private String zlkMc;

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

        public String getMarketName() {
            return marketName;
        }

        public void setMarketName(String marketName) {
            this.marketName = marketName;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        public String getZlkId() {
            return zlkId;
        }

        public void setZlkId(String zlkId) {
            this.zlkId = zlkId;
        }

        public String getZlkMc() {
            return zlkMc;
        }

        public void setZlkMc(String zlkMc) {
            this.zlkMc = zlkMc;
        }
    }
}
