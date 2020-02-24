package com.osiris.farmers.model;

public class XiaofangDe {


    /**
     * result : 0
     * message : 1
     * data : {"id":5,"titleMsg":"sssssss","xiaofangdwId":"1","xiaofangdwName":"1","tupian":"1582078557703.png","upTime":"2020-02-19 10:15:695","resultMsg":null,"userId":"53","marketId":"20","marketName":"观音山新城菜市场"}
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
         * id : 5
         * titleMsg : sssssss
         * xiaofangdwId : 1
         * xiaofangdwName : 1
         * tupian : 1582078557703.png
         * upTime : 2020-02-19 10:15:695
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
        private Object resultMsg;
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

        public Object getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(Object resultMsg) {
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
