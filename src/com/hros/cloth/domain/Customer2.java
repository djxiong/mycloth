package com.hros.cloth.domain;

public class Customer2 {
	/**
	 * ����ID
	 */
	private Integer customer2ID=0;
	
	/**
	 * �ͻ����
	 */
	private String customerNumber;
	
	/**
	 * �ͻ�����
	 */
	private String name;
	
	/**
	 * �ͻ��绰
	 */
	private String phone;

	public Integer getCustomer2ID() {
		return customer2ID;
	}

	public void setCustomer2ID(Integer customerID) {
		this.customer2ID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public boolean equals(Object another){
		if(! (another instanceof Customer2)){
			return false;
		}
		return customer2ID.equals(((Customer2)another).getCustomer2ID());
	}
	
	@Override
	public int hashCode(){
		return customer2ID.hashCode();
	}	
}
