package com.hros.bas.domain;

import com.hros.user.domain.RoleInfo;

public class MenuInfo implements Comparable{
	private Integer menuID = 0;
	private String menuName = "";
	/**
	 * 父节点
	 */
	private Integer fMenuID = 0;
	/**
	 * 窗口类名
	 */
	private String winClass = "";
	private Integer isShow = 1;
	private Integer seq = 0;
	private String serviceName = "";
	
	public MenuInfo(){
		
	}

	public void finalize() throws Throwable {

	}

	public Integer getMenuID() {
		return menuID;
	}

	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getFMenuID() {
		return fMenuID;
	}

	public void setFMenuID(Integer fMenuID) {
		this.fMenuID = fMenuID;
	}

	public String getWinClass() {
		return winClass;
	}

	public void setWinClass(String winClass) {
		this.winClass = winClass;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof MenuInfo)){
			return false;
		}
		return menuID.equals(((MenuInfo)another).getMenuID());
	}
	
	@Override
	public int hashCode(){
		return menuID.hashCode();
	}
	@Override
	public int compareTo(Object another){
		if(!(another instanceof MenuInfo)){
			return 1;
		}
		MenuInfo temp =(MenuInfo)another;
		return Integer.valueOf(menuID).compareTo(temp.getMenuID());
	}
}
