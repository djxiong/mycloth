package com.hros.user.domain;


public class RoleInfo {
	
	private Integer roleID=0;
	
	/**
	 * ��ɫ����
	 */
	private String roleName="�½�ɫ";

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof RoleInfo)){
			return false;
		}
		return roleID.equals(((RoleInfo)another).getRoleID());
	}
	
	@Override
	public int hashCode(){
		return roleID.hashCode();
	}
	
}
