package com.osiris.farmers.model;

import java.util.List;

public class SupplyerBean {
    private String message;
    private int result;

    private List<StoreSupplier.CustomerBean> customer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<StoreSupplier.CustomerBean> getCustomer() {
        return customer;
    }

    public void setCustomer(List<StoreSupplier.CustomerBean> customer) {
        this.customer = customer;
    }
}
