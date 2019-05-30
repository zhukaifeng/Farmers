package com.osiris.farmers.model;

public class ChargeManager {



	private String wholesaleMarket;
	private String payStall;
	private String personCharge;
	private String payShould;
	private String payNot;
	private String date;

	public ChargeManager(String wholesaleMarket, String payStall, String personCharge, String payShould, String payNot, String date) {
		this.wholesaleMarket = wholesaleMarket;
		this.payStall = payStall;
		this.personCharge = personCharge;
		this.payShould = payShould;
		this.payNot = payNot;
		this.date = date;
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

	public String getPersonCharge() {
		return personCharge;
	}

	public void setPersonCharge(String personCharge) {
		this.personCharge = personCharge;
	}

	public String getPayShould() {
		return payShould;
	}

	public void setPayShould(String payShould) {
		this.payShould = payShould;
	}

	public String getPayNot() {
		return payNot;
	}

	public void setPayNot(String payNot) {
		this.payNot = payNot;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
