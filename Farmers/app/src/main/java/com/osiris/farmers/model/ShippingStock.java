package com.osiris.farmers.model;

public class ShippingStock {

    private String type;
    private String name;
    private String count;

    public ShippingStock(String type, String name, String count) {
        this.type = type;
        this.name = name;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
