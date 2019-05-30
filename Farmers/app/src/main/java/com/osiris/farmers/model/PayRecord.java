package com.osiris.farmers.model;

public class PayRecord {

    private String payCount;
    private String payDate;
    private String payType;

    public PayRecord(String payCount, String payDate, String payType) {
        this.payCount = payCount;
        this.payDate = payDate;
        this.payType = payType;
    }

    public String getPayCount() {
        return payCount;
    }

    public void setPayCount(String payCount) {
        this.payCount = payCount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
