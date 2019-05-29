package com.osiris.farmers.model;

public class PunishDetail {

    private String serialNum;
    private String regulations;
    private String forfeit;

    public PunishDetail(String serialNum, String regulations, String forfeit) {
        this.serialNum = serialNum;
        this.regulations = regulations;
        this.forfeit = forfeit;
    }


    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }

    public String getForfeit() {
        return forfeit;
    }

    public void setForfeit(String forfeit) {
        this.forfeit = forfeit;
    }
}
