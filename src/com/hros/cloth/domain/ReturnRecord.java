package com.hros.cloth.domain;

import java.util.Date;

/**
 * 退货记录
 * @author Administrator
 *
 */
public class ReturnRecord {
	private Integer returnRecordID;
	
	/**
	 * 退货的衣服ID
	 */
	private Integer clothID;
	/**
	 * 退货日期
	 */
	private Date returnDate;
	/**
	 * 退货原因
	 */
	private String reason;
	/**
	 * 退货数量
	 */
	private Integer count;
	public Integer getReturnRecordID() {
		return returnRecordID;
	}
	public void setReturnRecordID(Integer returnRecordID) {
		this.returnRecordID = returnRecordID;
	}
	public Integer getClothID() {
		return clothID;
	}
	public void setClothID(Integer clothID) {
		this.clothID = clothID;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date date) {
		this.returnDate = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
