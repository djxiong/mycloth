package com.hros.reccost.domain;

import java.util.Date;

/**
 * 招聘费用计算
 * @author PB
 *
 */
public class RecCost {
	private int recId = 0;
	
	private int recFid = 0;
	
	private String recName = "";
	
	/**
	 * 入职信息ID
	 */
	private int staffStateId = 0;
	
	/**
	 * 招聘人员ID
	 */
	private int recUserId = 0;
	
	/**
	 * 付费开始时间
	 */
	private Date costStartDate;
	
	/**
	 * 付费结束时间
	 */
	private Date costEndDate;
	
	/**
	 * 是否一次性付费
	 */
	private boolean isDisposable = false;
	
	/**
	 * 费用
	 * 格式：1,2,3;6,5,4,3;
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
