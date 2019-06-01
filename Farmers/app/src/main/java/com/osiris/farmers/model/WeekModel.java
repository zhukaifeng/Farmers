package com.osiris.farmers.model;

public class WeekModel {

	private String date;
	private String week;
	private boolean select;

	public WeekModel(String date, String week, boolean select) {
		this.date = date;
		this.week = week;
		this.select = select;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
}
