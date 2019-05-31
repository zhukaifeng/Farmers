package com.osiris.farmers.model;

public class StockPurchase {

    private String productName;
    private String productType;
    private String productCount;
    private String productPrice;
    private String productSuppliert;
    private String date;

    public StockPurchase(String productName, String productType, String productCount, String productPrice, String productSuppliert, String date) {
        this.productName = productName;
        this.productType = productType;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.productSuppliert = productSuppliert;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSuppliert() {
        return productSuppliert;
    }

    public void setProductSuppliert(String productSuppliert) {
        this.productSuppliert = productSuppliert;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
