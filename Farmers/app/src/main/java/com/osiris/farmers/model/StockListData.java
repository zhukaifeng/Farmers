package com.osiris.farmers.model;

public class StockListData {

    private String name;
    private String type;
    private String count;
    private String price;
    private String total;
    private boolean voucher;

    public StockListData(String name, String type, String count, String price, String total, boolean voucher) {
        this.name = name;
        this.type = type;
        this.count = count;
        this.price = price;
        this.total = total;
        this.voucher = voucher;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public boolean isVoucher() {
        return voucher;
    }

    public void setVoucher(boolean voucher) {
        this.voucher = voucher;
    }
}
