package com.hros.user.domain;

public class RoleUserMap {
	private Integer roleUserID;
	private Integer userID;
	private Integer roleID;
	
	
	
	public Integer getRoleUserID() {
		return roleUserID;
	}
	public void setRoleUserID(Integer roleUserID) {
		this.roleUserID = roleUserID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof RoleUserMap)){
			return false;
		}
		return roleUserID.equals(((RoleUserMap)another).getRoleUserID());
	}
	
	@Override
	public int hashCode(){
		return roleUserID.hashCode();
	}
}
