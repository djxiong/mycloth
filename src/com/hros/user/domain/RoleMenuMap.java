package com.hros.user.domain;

public class RoleMenuMap {
	private Integer roleMenuID;
	private Integer roleID;
	private Integer menuID;
	
	
	
	public Integer getRoleMenuID() {
		return roleMenuID;
	}
	public void setRoleMenuID(Integer roleMenuID) {
		this.roleMenuID = roleMenuID;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public Integer getMenuID() {
		return menuID;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof RoleMenuMap)){
			return false;
		}
		return roleMenuID.equals(((RoleMenuMap)another).getRoleMenuID());
	}
	
	@Override
	public int hashCode(){
		return roleMenuID.hashCode();
	}
	
		
}
