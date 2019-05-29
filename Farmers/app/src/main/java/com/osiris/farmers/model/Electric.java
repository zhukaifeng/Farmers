package com.osiris.farmers.model;

public class Electric {


	private String num;
	private String name;
	private String payCount;


	public Electric(String num, String name, String payCount) {
		this.num = num;
		this.name = name;
		this.payCount = payCount;
	}


	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayCount() {
		return payCount;
	}

	public void setPayCount(String payCount) {
		this.payCount = payCount;
	}
}
