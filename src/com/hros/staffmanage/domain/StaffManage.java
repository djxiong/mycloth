package com.hros.staffmanage.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StaffManage implements Serializable{
	private Integer staffID = 0;
	private String staffCode = "";
	private String staffName = "";
	private String staffSex = "";
	private String identityCard = "";
	private String address = "";
	private String phone = "";
	private String homeAddress = "";
	private String homePhone = "";
	private String state = "";
	private String wageNumber = "";
	private String wageBank = "";
	private Integer age = 0;
	public StaffManage(){
		
	}
	public StaffManage(Integer staffID, String staffCode, String staffName,
			String staffSex, String identityCard, String address, String phone,
			String homeAddress, String homePhone, String state,
			String wageNumber, String wageBank,Integer age) {
		super();
		this.staffID = staffID;
		this.staffCode = staffCode;
		this.staffName = staffName;
		this.staffSex = staffSex;
		this.identityCard = identityCard;
		this.address = address;
		this.phone = phone;
		this.homeAddress = homeAddress;
		this.homePhone = homePhone;
		this.state = state;
		this.wageNumber = wageNumber;
		this.wageBank = wageBank;
		this.age = age;
	}

	public Integer getStaffID() {
		return staffID;
	}
	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffSex() {
		return staffSex;
	}
	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getWageNumber() {
		return wageNumber;
	}
	public void setWageNumber(String wageNumber) {
		this.wageNumber = wageNumber;
	}
	public String getWageBank() {
		return wageBank;
	}
	public void setWageBank(String wageBank) {
		this.wageBank = wageBank;
	}
	public Integer getAge(){
		return age;
	}
	public void age(Integer age){
		this.age = age;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	
}
