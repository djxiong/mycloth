package com.hros.company.domain;

import com.hros.user.domain.RoleInfo;

public class Company {
	private int compID = 0;
	/** 父节点。 */
	private int fcompID = 0;
	/** 公司编码。 */
	private String compCode = "";
	/** 公司名称。 */
	private String compName = "";
	/** 负责人。 */
	private String compLegalPerson = "";
	/** seq。 */
	private int seq = 0;
	
	public int getCompID() {
		return compID;
	}
	public void setCompID(int compID) {
		this.compID = compID;
	}
	public int getFcompID() {
		return fcompID;
	}
	public void setFcompID(int fcompID) {
		this.fcompID = fcompID;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompLegalPerson() {
		return compLegalPerson;
	}
	public void setCompLegalPerson(String compLegalPerson) {
		this.compLegalPerson = compLegalPerson;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	@Override
	public String toString(){
		return compName;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof Company)){
			return false;
		}
		return compID == (((Company)another).getCompID());
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(compID).hashCode();
	}
}
