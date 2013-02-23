package com.hros.cloth.domain;

import java.util.Date;

public class OrderHistory {

	private Integer orderHistoryID;
	
	private Integer customerID;
	
	private Integer clothID;
	
	/**
	 * 消费金额,如果是换货,则表示换货差价
	 */
	private Float consumption;
	
	/**
	 * 消费日期
	 */
	private Date consumeDate;
	
	/**
	 * 交易状态
	 */
	private String state;
	
	/**
	 * 订单号
	 */
	private String orderNumber;
	
	/**
	 * 被换货的订单ID
	 */
	private Integer exchangedOrderID;
	
	/**
	 * 利润
	 */
	private Float profit;
	

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	/**
	 *正常购物
	 */
	public static final String STATE_SUCCESS="SUCCESS";
	/**
	 * 作废
	 */
	public static final String STATE_INVALID="INVALID";
	/**
	 * 换货
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
