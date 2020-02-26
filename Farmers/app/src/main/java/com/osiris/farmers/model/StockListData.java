package com.osiris.farmers.model;

public class StockListData {

    private String name;
    private String type;
    private int count;
    private double price;
    private double total;
    private boolean voucher;
    private int cusId;
    private String cusNo;
    private int id;
    private String time;
    private String imgPath;

    public StockListData(int id, String name, String type, int count, double price, double total, boolean voucher, String cusNo, String time
            , int cusId, String imgPath) {
        this.name = name;
        this.cusNo = cusNo;
        this.type = type;
        this.count = count;
        this.price = price;
        this.total = total;
        this.voucher = voucher;
        this.time = time;
        this.id = id;
        this.imgPath = imgPath;
        this.cusId = cusId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isVoucher() {
        return voucher;
    }

    public void setVoucher(boolean voucher) {
        this.voucher = voucher;
    }
}
