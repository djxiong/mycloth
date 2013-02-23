package com.hros.insurance.domain;

import java.util.Date;

public class InsuranceHistoryInfo {
	
	private Integer insuranceHistoryID;
	
	/**
	 * �籣��ϸ
	 */
	private InsuranceDetailInfo detail;
	
	/**
	 * Ա��ID
	 */
	private Integer staffManageID;
	/**
	 * ��ʲôʱ����ɵĸ��籣
	 */
	private Date payDate;
	/**
	 * �ɵ��ĸ��·ݵ��籣
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
