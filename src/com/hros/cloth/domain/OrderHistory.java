package com.hros.cloth.domain;

import java.util.Date;

public class OrderHistory {

	private Integer orderHistoryID;
	
	private Integer customerID;
	
	private Integer clothID;
	
	/**
	 * ���ѽ��,����ǻ���,���ʾ�������
	 */
	private Float consumption;
	
	/**
	 * ��������
	 */
	private Date consumeDate;
	
	/**
	 * ����״̬
	 */
	private String state;
	
	/**
	 * ������
	 */
	private String orderNumber;
	
	/**
	 * �������Ķ���ID
	 */
	private Integer exchangedOrderID;
	
	/**
	 * ����
	 */
	private Float profit;
	

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	/**
	 *��������
	 */
	public static final String STATE_SUCCESS="SUCCESS";
	/**
	 * ����
	 */
	public static final String STATE_INVALID="INVALID";
	/**
	 * ����
	 */
	public static final String STATE_EXCHANGE="EXCHANGE";

	public Integer getOrderHistoryID() {
		return orderHistoryID;
	}

	public void setOrderHistoryID(Integer orderHistoryID) {
		this.orderHistoryID = orderHistoryID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getClothID() {
		return clothID;
	}

	public void setClothID(Integer clothID) {
		this.clothID = clothID;
	}

	public Float getConsumption() {
		return consumption;
	}

	public void setConsumption(Float consumption) {
		this.consumption = consumption;
	}

	public Date getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof OrderHistory)){
			return false;
		}
		return orderHistoryID.equals(((OrderHistory)another).getOrderHistoryID());
	}
	
	@Override
	public int hashCode(){
		return orderHistoryID.hashCode();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getExchangedOrderID() {
		return exchangedOrderID;
	}

	public void setExchangedOrderID(Integer exchangedOrderID) {
		this.exchangedOrderID = exchangedOrderID;
	}
		
	
	
}
