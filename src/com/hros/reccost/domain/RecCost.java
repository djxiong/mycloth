package com.hros.reccost.domain;

import java.util.Date;

/**
 * ��Ƹ���ü���
 * @author PB
 *
 */
public class RecCost {
	private int recId = 0;
	
	private int recFid = 0;
	
	private String recName = "";
	
	/**
	 * ��ְ��ϢID
	 */
	private int staffStateId = 0;
	
	/**
	 * ��Ƹ��ԱID
	 */
	private int recUserId = 0;
	
	/**
	 * ���ѿ�ʼʱ��
	 */
	private Date costStartDate;
	
	/**
	 * ���ѽ���ʱ��
	 */
	private Date costEndDate;
	
	/**
	 * �Ƿ�һ���Ը���
	 */
	private boolean isDisposable = false;
	
	/**
	 * ����
	 * ��ʽ��1,2,3;6,5,4,3;
	 */
	private String costAccount = "";

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getRecFid() {
		return recFid;
	}

	public void setRecFid(int recFid) {
		this.recFid = recFid;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public int getStaffStateId() {
		return staffStateId;
	}

	public void setStaffStateId(int staffStateId) {
		this.staffStateId = staffStateId;
	}

	public int getRecUserId() {
		return recUserId;
	}

	public void setRecUserId(int recUserId) {
		this.recUserId = recUserId;
	}

	public Date getCostStartDate() {
		return costStartDate;
	}

	public void setCostStartDate(Date costStartDate) {
		this.costStartDate = costStartDate;
	}

	public Date getCostEndDate() {
		return costEndDate;
	}

	public void setCostEndDate(Date costEndDate) {
		this.costEndDate = costEndDate;
	}

	public boolean isDisposable() {
		return isDisposable;
	}

	public void setDisposable(boolean isDisposable) {
		this.isDisposable = isDisposable;
	}

	public String getCostAccount() {
		return costAccount;
	}

	public void setCostAccount(String costAccount) {
		this.costAccount = costAccount;
	}
}
