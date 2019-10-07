package com.model.bean;

import java.sql.Date;

public class MedicalRecord {
	
	private int id;
	private int pid;
	private String description;
	private String medicalhistory;
	private String familyhistory;
	private String initialresult;
	private String result;
	private String finalresult;
	private int status;
	private int operator;
	private Date operateDate;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMedicalhistory() {
		return medicalhistory;
	}
	public void setMedicalhistory(String medicalhistory) {
		this.medicalhistory = medicalhistory;
	}
	public String getFamilyhistory() {
		return familyhistory;
	}
	public void setFamilyhistory(String familyhistory) {
		this.familyhistory = familyhistory;
	}
	public String getInitialresult() {
		return initialresult;
	}
	public void setInitialresult(String initialresult) {
		this.initialresult = initialresult;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getFinalresult() {
		return finalresult;
	}
	public void setFinalresult(String finalresult) {
		this.finalresult = finalresult;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
}
