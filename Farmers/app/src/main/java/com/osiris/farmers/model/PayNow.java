package com.osiris.farmers.model;

public class PayNow {

    private String payType;
    private String payCount;

    public PayNow(String payType, String payCount) {
        this.payType = payType;
        this.payCount = payCount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayCount() {
        return payCount;
    }

    public void setPayCount(String payCount) {
        this.payCount = payCount;
    }
}
