package com.model.bean;

import java.sql.Date;

public class Patient {
	private int pid;
	private String pname;
	private String gender;
	private int age;
	private String year;
	private String month;
	private String birthday;
	private String idcard;
	private String address;
	private int levelid;
	private int deptid;
	private int doctorid;
	private Date createDate;
	private int cost;
	private String pstatus;
	private int status;
	private int operator;
	private Date operateDate;
	
	private Level level;
	private Dept dept;
	private Doctor doctor;
	private MedicalRecord medicalRecord;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLevelid() {
		return levelid;
	}
	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
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
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	
	
	
}
