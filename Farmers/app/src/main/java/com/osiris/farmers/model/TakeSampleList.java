package com.osiris.farmers.model;

public class TakeSampleList {


	private int sampleId;
	private String sampleType;
	private String sampleCount;
	private String sampleTime;
	private boolean delete;


	public TakeSampleList(int sampleId, String sampleType, String sampleCount, String sampleTime) {
		this.sampleId = sampleId;
		this.sampleType = sampleType;
		this.sampleCount = sampleCount;
		this.sampleTime = sampleTime;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public int getSampleId() {
		return sampleId;
	}

	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public String getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(String sampleCount) {
		this.sampleCount = sampleCount;
	}

	public String getSampleTime() {
		return sampleTime;
	}

	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}
}
