package com.hros.user.domain;


public class UserInfo {
	private Integer userID;
	private String userCode;
	private String userName;
	private String loginName;
	private String password;
	/**
	 * 身份证
	 */
	private String identityCard;
	private String address;
	private String phone;
	private String shortPhone;
	/**
	 * 所属公司ID company
	 */
	private int compID;
	/**
	 * 所属公司ID
	 */
	@Deprecated
	private int deptID;
	/**
	 * 职位ID
	 */
	private int posID;
	/**
	 * 所管理的客户ID，格式：,001,002, customer
	 */
	private String customersID;
	/**
	 * 所管理的自己的公司ID号，格式：,001,002, company
	 */
	private String compsID;

	public UserInfo(){

	}

	public void finalize() throws Throwable {

	}



	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
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

	public String getShortPhone() {
		return shortPhone;
	}

	public void setShortPhone(String shortPhone) {
		this.shortPhone = shortPhone;
	}

	public int getCompID() {
		return compID;
	}

	public void setCompID(int compID) {
		this.compID = compID;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public int getPosID() {
		return posID;
	}

	public void setPosID(int posID) {
		this.posID = posID;
	}

	public String getCustomersID() {
		return customersID;
	}

	public void setCustomersID(String customersID) {
		this.customersID = customersID;
	}

	public String getCompsID() {
		return compsID;
	}

	public void setCompsID(String compsID) {
		this.compsID = compsID;
	}
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof UserInfo)){
			return false;
		}
		return userID.equals(((UserInfo)another).getUserID());
	}
	
	@Override
	public int hashCode(){
		return userID.hashCode();
	}
}
