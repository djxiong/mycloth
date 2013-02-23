package com.hros.staffstate.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * Ա������ְ����
 * 
 * @pdOid 
 */
@SuppressWarnings("serial")
public class StaffState implements Serializable{
	/**
	 * ����ְID��
	 * 
	 * @pdOid 
	 */
	public int staffstateID;


	/**
	 * ��ְʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date entryDate;
	/**
	 * ��ͬǩ��ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date agreeSignedDate;
	/**
	 * ��ͬ����ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date agreeExpireDate;
	/**
	 * ��ͬ��ǩʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date agreeRenewDate;
	/**
	 * ����ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date toPostDate;
	/**
	 * ���ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date livePostDate;
	/**
	 * ��ְ����ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date quitApplayDate;
	/**
	 * ��ְʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date quitDate;
	/**
	 * ��ְ����ԱID��
	 * 
	 * @pdOid 
	 */
	public int quitUserID;
	/**
	 * �����ڡ�
	 * 
	 * @pdOid 
	 */
	public Date probation;
	/**
	 * ���š�
	 * 
	 * @pdOid 
	 */
	public String jobCode="";
	/**
	 * ��λ��
	 * 
	 * @pdOid 
	 */
	public String post="";
	/**
	 * �α�ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date joinInsuranceDate;
	/**
	 * ͣ��ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date disInsuranceDate;
	/**
	 * �籣ID��
	 * 
	 * @pdOid 
	 */
	public int insuranceID;
	/**
	 * �籣��Чʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date insurancelInDate;
	/**
	 * �籣����ʱ�䡣
	 * 
	 * @pdOid 
	 */
	public Date insurancelOutDate;
	/**
	 * �������Ч�ӳ�������
	 * 
	 * @pdOid 
	 */
	public int serviceFeeDelay;

	/** 
	 * �û�ID
	 *  */
	public int userId;
	/** 
	 * Ա��ID
	 *  */
	public int staffID;
	/**
	 * �ͻ�ID
	 */
	public int custID;
	/** 
	 * ��ְ����ID
	 *  */
	public int entryFileID;
	/**
	 * ��ְ����ID
	 */
	public int quitFileID;
	/**
	 *�����ID
	 */
	public int serviceFeeID;
	/**
	 * ״̬
	 */
	public String state;
	/**
	 * ��Ƹ��ԱID
	 */
	public int recUserId;
	/**
	 * ��Ƹ����ID
	 */
	public int recId;
	/**
	 * ���ÿ�ʼʱ��
	 */
	public Date costStartDate;
	/**
	 * ���ý���ʱ��
	 */
	public Date costEndDate;
	
	public int getStaffstateID() {
		return staffstateID;
	}

	public void setStaffstateID(int staffstateID) {
		this.staffstateID = staffstateID;
	}
	public Date getEntryDate() {
		if(entryDate!=null){
			return new java.sql.Date(entryDate.getTime());
		}else {
			return entryDate;
		}
		
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getAgreeSignedDate() {
		if(agreeSignedDate!=null){
			return new java.sql.Date(agreeSignedDate.getTime());
		}else{
			return agreeSignedDate;
		}
		
	}

	public void setAgreeSignedDate(Date agreeSignedDate) {
		this.agreeSignedDate = agreeSignedDate;
	}

	public Date getAgreeExpireDate() {
		if(agreeExpireDate!=null){
			return new java.sql.Date(agreeExpireDate.getTime());
		}else {
			return agreeExpireDate;
		}
		
	}

	public void setAgreeExpireDate(Date agreeExpireDate) {
		this.agreeExpireDate = agreeExpireDate;
	}

	public Date getAgreeRenewDate() {
		if(agreeRenewDate!=null){
			return new java.sql.Date(agreeRenewDate.getTime());
		}else {
			return agreeRenewDate;
		}
		
	}

	public void setAgreeRenewDate(Date agreeRenewDate) {
		this.agreeRenewDate = agreeRenewDate;
	}

	public Date getToPostDate() {
		if(toPostDate!=null){
			return new java.sql.Date(toPostDate.getTime());
		}else {
			return toPostDate;
		}
	}

	public void setToPostDate(Date toPostDate) {
		this.toPostDate = toPostDate;
	}

	public Date getLivePostDate() {
		if(livePostDate!=null){
			return new java.sql.Date(livePostDate.getTime());
		}else {
			return livePostDate;
		}
	}

	public void setLivePostDate(Date livePostDate) {
		this.livePostDate = livePostDate;
	}

	public Date getQuitApplayDate() {
		if(quitApplayDate!=null){
			return new java.sql.Date(quitApplayDate.getTime());
		}else {
			return quitApplayDate;
		}
	}

	public void setQuitApplayDate(Date quitApplayDate) {
		this.quitApplayDate = quitApplayDate;
	}

	public Date getQuitDate() {
		if(quitDate!=null){
			return new java.sql.Date(quitDate.getTime());
		}else {
			return quitDate;
		}
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public int getQuitUserID() {
		
		return quitUserID;
	}

	public void setQuitUserID(int quitUserID) {
		this.quitUserID = quitUserID;
	}

	public Date getProbation() {
		if(probation!=null){
			return new java.sql.Date(probation.getTime());
		}else {
			return probation;
		}
	}

	public void setProbation(Date probation) {
		this.probation = probation;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getJoinInsuranceDate() {
		if(joinInsuranceDate!=null){
			return new java.sql.Date(joinInsuranceDate.getTime());
		}else {
			return joinInsuranceDate;
		}
	}

	public void setJoinInsuranceDate(Date joinInsuranceDate) {
		this.joinInsuranceDate = joinInsuranceDate;
	}

	public Date getDisInsuranceDate() {
		if(disInsuranceDate!=null){
			return new java.sql.Date(disInsuranceDate.getTime());
		}else {
			return disInsuranceDate;
		}
	}

	public void setDisInsuranceDate(Date disInsuranceDate) {
		this.disInsuranceDate = disInsuranceDate;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public Date getInsurancelInDate() {
		if(insurancelInDate!=null){
			return new java.sql.Date(insurancelInDate.getTime());
		}else {
			return insurancelInDate;
		}
	}

	public void setInsurancelInDate(Date insurancelInDate) {
		this.insurancelInDate = insurancelInDate;
	}

	public Date getInsurancelOutDate() {
		if(insurancelOutDate!=null){
			return new java.sql.Date(insurancelOutDate.getTime());
		}else {
			return insurancelOutDate;
		}
	}

	public void setInsurancelOutDate(Date insurancelOutDate) {
		this.insurancelOutDate = insurancelOutDate;
	}

	public int getServiceFeeDelay() {
		return serviceFeeDelay;
	}

	public void setServiceFeeDelay(int serviceFeeDelay) {
		this.serviceFeeDelay = serviceFeeDelay;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getEntryFileID() {
		return entryFileID;
	}

	public void setEntryFileID(int entryFileID) {
		this.entryFileID = entryFileID;
	}

	public int getQuitFileID() {
		return quitFileID;
	}

	public void setQuitFileID(int quitFileID) {
		this.quitFileID = quitFileID;
	}

	public int getServiceFeeID() {
		return serviceFeeID;
	}

	public void setServiceFeeID(int serviceFeeID) {
		this.serviceFeeID = serviceFeeID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRecUserId() {
		return recUserId;
	}

	public void setRecUserId(int recUserId) {
		this.recUserId = recUserId;
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public Date getCostStartDate() {
		if(costStartDate!=null){
			return new java.sql.Date(costStartDate.getTime());
		}else {
			return costStartDate;
		}
	}

	public void setCostStartDate(Date costStartDate) {
		this.costStartDate = costStartDate;
	}

	public Date getCostEndDate() {
		if(costEndDate!=null){
			return new java.sql.Date(costEndDate.getTime());
		}else {
			return costEndDate;
		}
	}

	public void setCostEndDate(Date costEndDate) {
		this.costEndDate = costEndDate;
	}


}
