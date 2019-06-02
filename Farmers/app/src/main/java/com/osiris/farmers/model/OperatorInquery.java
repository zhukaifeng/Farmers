package com.osiris.farmers.model;

public class OperatorInquery {


	private String stallNum;
	private String companyName;
	private String businessLincense;
	private String connect;
	private boolean clicked;



	public OperatorInquery(String stallNum, String companyName, String businessLincense, String connect) {
		this.stallNum = stallNum;
		this.companyName = companyName;
		this.businessLincense = businessLincense;
		this.connect = connect;
	}


	public String getStallNum() {
		return stallNum;
	}

	public void setStallNum(String stallNum) {
		this.stallNum = stallNum;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public String getStallName() {
		return stallNum;
	}

	public void setStallName(String stallNum) {
		this.stallNum = stallNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBusinessLincense() {
		return businessLincense;
	}

	public void setBusinessLincense(String businessLincense) {
		this.businessLincense = businessLincense;
	}

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}
}
