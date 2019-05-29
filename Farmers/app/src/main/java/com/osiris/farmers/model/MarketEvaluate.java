package com.osiris.farmers.model;

public class MarketEvaluate {

    private String marketName;
    private String jurisdictionUnit;
    private String appraise;
    private String date;

    public MarketEvaluate(String marketName, String jurisdictionUnit, String appraise, String date) {
        this.marketName = marketName;
        this.jurisdictionUnit = jurisdictionUnit;
        this.appraise = appraise;
        this.date = date;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getJurisdictionUnit() {
        return jurisdictionUnit;
    }

    public void setJurisdictionUnit(String jurisdictionUnit) {
        this.jurisdictionUnit = jurisdictionUnit;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
