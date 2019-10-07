package com.model.bean;

public class InspectItemRecord {

	private int id;
	private int pid;
	private int inspectid;
	private int amount;
	private int paystatus;
	
	private InspectItem inspectItem;
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
	public int getInspectid() {
		return inspectid;
	}
	public void setInspectid(int inspectid) {
		this.inspectid = inspectid;
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
	public InspectItem getInspectItem() {
		return inspectItem;
	}
	public void setInspectItem(InspectItem inspectItem) {
		this.inspectItem = inspectItem;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
