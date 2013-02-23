package com.hros.insurance.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * �����һ����������
 * @author xiongdajun
 *
 */
public class InsuranceDetailInfo {

	/**
	 * ����id
	 */
	private Integer insuranceDetailID;
	/**
	 * ��������
	 */
	private String insuranceDetailName="";
	/**
	 * ���ɻ���
	 */
	private Float base=0F;
	
	/**
	 * ��˾���ɱ���
	 */
	private Float companyRate=0F;
	
	/**
	 * ���˽��ɱ���
	 */
	private Float personalRate=0F;
	
	/**
	 * �������������籣
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
	 * ��ȡ��λ���ɽ��
	 * @return
	 */
	public Float getCompanyAmount(){
		return base * companyRate;
	}
	
	/**
	 * ��ȡ���˽��ɽ��
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
