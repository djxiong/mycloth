package com.hros.insurance.domain;

import java.util.Date;

public class InsuranceHistoryInfo {
	
	private Integer insuranceHistoryID;
	
	/**
	 * 社保明细
	 */
	private InsuranceDetailInfo detail;
	
	/**
	 * 员工ID
	 */
	private Integer staffManageID;
	/**
	 * 在什么时候缴纳的该社保
	 */
	private Date payDate;
	/**
	 * 缴的哪个月份的社保
	 */
	private Date destDate;
	
	
	
	
	public Integer getInsuranceHistoryID() {
		return insuranceHistoryID;
	}
	public void setInsuranceHistoryID(Integer insuranceHistoryID) {
		this.insuranceHistoryID = insuranceHistoryID;
	}
	public InsuranceDetailInfo getDetail() {
		return detail;
	}
	public void setDetail(InsuranceDetailInfo detail) {
		this.detail = detail;
	}
	public Integer getStaffManageID() {
		return staffManageID;
	}
	public void setStaffManageID(Integer staffManageID) {
		this.staffManageID = staffManageID;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getDestDate() {
		return destDate;
	}
	public void setDestDate(Date destDate) {
		this.destDate = destDate;
	}
	
	
}
