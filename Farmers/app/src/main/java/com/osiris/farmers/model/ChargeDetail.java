package com.osiris.farmers.model;

public class ChargeDetail {


	private String chargeType;
	private String paddingPay;
	private String hasPay;
	private String date;

	public ChargeDetail(String chargeType, String paddingPay, String hasPay, String date) {
		this.chargeType = chargeType;
		this.paddingPay = paddingPay;
		this.hasPay = hasPay;
		this.date = date;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getPaddingPay() {
		return paddingPay;
	}

	public void setPaddingPay(String paddingPay) {
		this.paddingPay = paddingPay;
	}

	public String getHasPay() {
		return hasPay;
	}

	public void setHasPay(String hasPay) {
		this.hasPay = hasPay;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
