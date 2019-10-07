package com.model.bean;

public class CheckItemRecord {
	
	private int id;
	private int pid;
	private int cid;
	private int amount;
	private int paystatus;
	private CheckItem checkItem;
	private Patient patient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public CheckItem getCheckItem() {
		return checkItem;
	}
	public void setCheckItem(CheckItem checkItem) {
		this.checkItem = checkItem;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
