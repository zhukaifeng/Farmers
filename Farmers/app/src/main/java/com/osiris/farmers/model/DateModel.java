package com.osiris.farmers.model;

public class DateModel {

	private String date;
	private boolean clicked;

	public DateModel(String date, boolean clicked) {
		this.date = date;
		this.clicked = clicked;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
}
