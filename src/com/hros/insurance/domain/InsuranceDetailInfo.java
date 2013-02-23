package com.hros.insurance.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 具体的一个保险种类
 * @author xiongdajun
 *
 */
public class InsuranceDetailInfo {

	/**
	 * 主键id
	 */
	private Integer insuranceDetailID;
	/**
	 * 保险名称
	 */
	private String insuranceDetailName="";
	/**
	 * 缴纳基数
	 */
	private Float base=0F;
	
	/**
	 * 公司缴纳比例
	 */
	private Float companyRate=0F;
	
	/**
	 * 个人缴纳比例
	 */
	private Float personalRate=0F;
	
	/**
	 * 本险种所属的社保
	 */
	//private InsuranceInfo insurance;
	private Integer insuranceID;
	
	public Integer getInsuranceDetailID() {
		return insuranceDetailID;
	}

	public void setInsuranceDetailID(Integer id) {
		this.insuranceDetailID = id;
	}

	public String getInsuranceDetailName() {
		return insuranceDetailName;
	}

	public void setInsuranceDetailName(String insuranceDetailName) {
		this.insuranceDetailName = insuranceDetailName;
	}

	public Float getBase() {
		return base;
	}

	public void setBase(Float base) {
		this.base = base;
	}

	public Float getCompanyRate() {
		return companyRate;
	}

	public void setCompanyRate(Float companyRate) {
		this.companyRate = companyRate;
	}

	public Float getPersonalRate() {
		return personalRate;
	}

	public void setPersonalRate(Float personalRate) {
		this.personalRate = personalRate;
	}


	public Integer getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}

	/**
	 * 获取单位缴纳金额
	 * @return
	 */
	public Float getCompanyAmount(){
		return base * companyRate;
	}
	
	/**
	 * 获取个人缴纳金额
	 * @return
	 */
	public Float getPersonalAmount(){
		return base * personalRate;
	}
	
	public String toString(){
		 return ToStringBuilder.reflectionToString(this);
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof InsuranceDetailInfo)){
			return false;
		}
		return insuranceDetailID.equals(((InsuranceDetailInfo)another).getInsuranceDetailID());
	}
	
	@Override
	public int hashCode(){
		return insuranceDetailID.hashCode();
	}
}
