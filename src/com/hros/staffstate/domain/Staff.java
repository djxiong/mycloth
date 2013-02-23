package com.hros.staffstate.domain;

/***********************************************************************
 * Module:  Staff.java
 * Author:  Administrator
 * Purpose: Defines the Class Staff
 ***********************************************************************/

import java.util.*;

/**
 * Ա����
 * 
 * @pdOid
 */
public class Staff {
	/**
	 * staffID��
	 * 
	 * @pdOid
	 */
	public int staffID;
	/**
	 * Ա����š�
	 * 
	 * @pdOid
	 */
	public String staffCode="";
	/**
	 * Ա��������
	 * 
	 * @pdOid
	 */
	public String staffName="";
	/**
	 * �Ա�
	 * 
	 * @pdOid
	 */
	public String staffSex="";
	/**
	 * ���֤��
	 * 
	 * @pdOid
	 */
	public String identityCard="";
	/**
	 * סַ��
	 * 
	 * @pdOid
	 */
	public String address="";
	/**
	 * �绰��
	 * 
	 * @pdOid
	 */
	public String phone="";
	/**
	 * �������ڵء�
	 * 
	 * @pdOid
	 */
	public String homeAddress="";
	/**
	 * ��ͥ�绰��
	 * 
	 * @pdOid
	 */
	public String homePhone="";
	/**
	 * ״̬��
	 * 
	 * @pdOid
	 */
	public String state="";
	/**
	 * ���ʿ��š�
	 * 
	 * @pdOid
	 */
	public String wageNumber;
	/**
	 * �����С�
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