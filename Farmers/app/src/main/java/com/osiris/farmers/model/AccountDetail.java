package com.osiris.farmers.model;

public class AccountDetail {

	private String date;
	private String dateRange;
	private double saleCount;
	private double buyCount;

	public AccountDetail(String date, String dateRange, double saleCount, double buyCount) {
		this.date = date;
		this.dateRange = dateRange;
		this.saleCount = saleCount;
		this.buyCount = buyCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public double getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public double getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
}
