package com.osiris.farmers.model;

public class PunishList {

    private String wholesaleMarket;
    private String payStall;
    private String punish;
    private String price;
    private String date;
    private boolean select;
    private boolean clicked;

    public PunishList(String wholesaleMarket, String payStall, String punish, String price, String date, boolean select) {
        this.wholesaleMarket = wholesaleMarket;
        this.payStall = payStall;
        this.punish = punish;
        this.price = price;
        this.date = date;
        this.select = select;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String getWholesaleMarket() {
        return wholesaleMarket;
    }

    public void setWholesaleMarket(String wholesaleMarket) {
        this.wholesaleMarket = wholesaleMarket;
    }

    public String getPayStall() {
        return payStall;
    }

    public void setPayStall(String payStall) {
        this.payStall = payStall;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
