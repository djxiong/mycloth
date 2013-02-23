package com.hros.customer.domain;

import com.hros.company.domain.Company;

public class Customer {
	/** custID。 */
	private int custID = 0;
	/** fCustID。 */
	private int fCustID = 0;
	/** 客户编码。 */
	private String custCode = "";
	/** 客户名称。 */
	private String custName = "";
	/** 法人。 */
	private String custLegalPerson = "";
	/** 地址。 */
	private String address = "";
	/** 电话。 */
	private String phone = "";
	/**服务费ID*/
	private int serviceFeeID;
	/** 服务费生效延迟天数。 */
	private int serviceFeeDelay = 0;
	/** 行业 */
	private String industry = "004";
	/** 客户等级 */
	private String custClass = "";
	/** 公司属性 */
	private String custAttr = "002";
	/** 备注 */
	private String remark = "";
	/** 所在地区 */
	private String custCity = "005";
	/** 客户类型 */
	private String custType = "003";
	/**整月服务费*/
	private double wholeMonthAccount = 0;
	/**社保ID*/
	private int insuranceId = 0;

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getfCustID() {
		return fCustID;
	}

	public void setfCustID(int fCustID) {
		this.fCustID = fCustID;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLegalPerson() {
		return custLegalPerson;
	}

	public void setCustLegalPerson(String custLegalPerson) {
		this.custLegalPerson = custLegalPerson;
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

	public int getServiceFeeDelay() {
		return serviceFeeDelay;
	}

	public void setServiceFeeDelay(int serviceFeeDelay) {
		this.serviceFeeDelay = serviceFeeDelay;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCustClass() {
		return custClass;
	}

	public void setCustClass(String custClass) {
		this.custClass = custClass;
	}

	public String getCustAttr() {
		return custAttr;
	}

	public void setCustAttr(String custAttr) {
		this.custAttr = custAttr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public double getWholeMonthAccount() {
		return wholeMonthAccount;
	}

	public void setWholeMonthAccount(double wholeMonthAccount) {
		this.wholeMonthAccount = wholeMonthAccount;
	}

	public int getServiceFeeID() {
		return serviceFeeID;
	}

	public void setServiceFeeID(int serviceFeeID) {
		this.serviceFeeID = serviceFeeID;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	@Override
	public String toString(){
		return custName;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof Customer)){
			return false;
		}
		return custID == (((Customer)another).getCustID());
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(custID).hashCode();
	}
}
