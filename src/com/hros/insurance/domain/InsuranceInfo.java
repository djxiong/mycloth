package com.hros.insurance.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class InsuranceInfo {
	
	/**
	 * ����id
	 */
	private Integer insuranceID;
	
	/**
	 * �籣����
	 */
	private String insuranceName;
	
	/**
	 * ���ڵ�ID
	 */
	private Integer treeNodeID;
	
	/**
	 * �����ľ��������б�
	 */
	private List<InsuranceDetailInfo> detailInsurances = new ArrayList<InsuranceDetailInfo>();

	public Integer getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public List<InsuranceDetailInfo> getDetailInsurances() {
		return detailInsurances;
	}

	public void setDetailInsurances(List<InsuranceDetailInfo> detailInsurances) {
		this.detailInsurances = detailInsurances;
	}
	
	/**
	 * ��ȡ�ϼƵĵ�λ���ɱ���
	 * @return
	 */
	public Float getTotalCompanyRate(){
		Float total = 0F;
		for(InsuranceDetailInfo insuranceDetailInfo:detailInsurances){
			total += insuranceDetailInfo.getCompanyRate();
		}
		return total;
	}
	
	/**
	 * ��ȡ�ϼƵĸ��˽��ɱ���
	 * @return
	 */
	public Float getTotalPersonalRate(){
		Float total = 0F;
		for(InsuranceDetailInfo insuranceDetailInfo:detailInsurances){
			total += insuranceDetailInfo.getPersonalRate();
		}
		return total;
	}
	
	/**
	 * ��ȡ�ϼƵĵ�λ���ɽ��
	 * @return
	 */
	public Float getTotalCompanyAmount(){
		Float total = 0F;
		for(InsuranceDetailInfo insuranceDetailInfo:detailInsurances){
			total += insuranceDetailInfo.getCompanyAmount();
		}
		return total;
	}
	
	/**
	 * ��ȡ�ϼƵĸ��˽��ɽ��
	 * @return
	 */
	public Float getTotalPersonalAmount(){
		Float total = 0F;
		for(InsuranceDetailInfo insuranceDetailInfo:detailInsurances){
			total += insuranceDetailInfo.getPersonalAmount();
		}
		return total;
	}
	
	public void addInsuranceDetailInfo(InsuranceDetailInfo insuranceDetailInfo) {
		detailInsurances.add(insuranceDetailInfo);
	}
	
	public Integer getTreeNodeID() {
		return treeNodeID;
	}

	public void setTreeNodeID(Integer treeNodeID) {
		this.treeNodeID = treeNodeID;
	}

	public String toString(){
		
		//return ToStringBuilder.reflectionToString(this);
		return this.insuranceName;
	}
	@Override
	public boolean equals(Object another){
		if(! (another instanceof InsuranceInfo)){
			return false;
		}
		return insuranceID.equals(((InsuranceInfo)another).getInsuranceID());
	}
	@Override
	public int hashCode(){
		return insuranceID.hashCode();
	}
}
