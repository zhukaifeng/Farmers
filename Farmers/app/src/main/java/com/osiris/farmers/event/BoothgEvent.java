package com.osiris.farmers.event;

public class BoothgEvent {

	private int id;
	private String twhmc;
	private int marketid;

	public BoothgEvent(int id, String twhmc, int marketid) {
		this.id = id;
		this.twhmc = twhmc;
		this.marketid = marketid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwhmc() {
		return twhmc;
	}

	public void setTwhmc(String twhmc) {
		this.twhmc = twhmc;
	}

	public int getMarketid() {
		return marketid;
	}

	public void setMarketid(int marketid) {
		this.marketid = marketid;
	}
}
