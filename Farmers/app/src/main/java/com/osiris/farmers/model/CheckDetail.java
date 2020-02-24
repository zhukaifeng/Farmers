package com.osiris.farmers.model;

public class CheckDetail {


    /**
     * result : 0
     * message : 1
     * data : {"id":4,"tupian":"1581958528791.png","upTime":"2020-02-18 00:55:791","resultMsg":"3333333","userId":"59","marketId":"18","marketName":null}
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
         * tupian : 1581958528791.png
         * upTime : 2020-02-18 00:55:791
         * resultMsg : 3333333
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
