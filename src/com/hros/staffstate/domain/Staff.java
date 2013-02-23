package com.hros.staffstate.domain;

/***********************************************************************
 * Module:  Staff.java
 * Author:  Administrator
 * Purpose: Defines the Class Staff
 ***********************************************************************/

import java.util.*;

/**
 * 员工。
 * 
 * @pdOid
 */
public class Staff {
	/**
	 * staffID。
	 * 
	 * @pdOid
	 */
	public int staffID;
	/**
	 * 员工编号。
	 * 
	 * @pdOid
	 */
	public String staffCode="";
	/**
	 * 员工姓名。
	 * 
	 * @pdOid
	 */
	public String staffName="";
	/**
	 * 性别。
	 * 
	 * @pdOid
	 */
	public String staffSex="";
	/**
	 * 身份证。
	 * 
	 * @pdOid
	 */
	public String identityCard="";
	/**
	 * 住址。
	 * 
	 * @pdOid
	 */
	public String address="";
	/**
	 * 电话。
	 * 
	 * @pdOid
	 */
	public String phone="";
	/**
	 * 户口所在地。
	 * 
	 * @pdOid
	 */
	public String homeAddress="";
	/**
	 * 家庭电话。
	 * 
	 * @pdOid
	 */
	public String homePhone="";
	/**
	 * 状态。
	 * 
	 * @pdOid
	 */
	public String state="";
	/**
	 * 工资卡号。
	 * 
	 * @pdOid
	 */
	public String wageNumber;
	/**
	 * 开户行。
	 * 
	 * @pdOid
	 */
	public String wageBank;

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Collection<StaffState> getStaffState() {
		return staffState;
	}

	public void setStaffState(Collection<StaffState> staffState) {
		this.staffState = staffState;
	}

	/**
	 * @pdRoleInfo migr=no name=StaffState assc=StaffUserMapping
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public Collection<StaffState> staffState;

}