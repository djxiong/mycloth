package com.hros.customer.domain;

public class CustomerContactPerson {
	/** contactID�� */
	private int contactID = 0;
	/**�ͻ���λID*/
	private int custID = 0;
	/** ��ϵ�˱��롣 */
	private String contactCode = "";
	/** ��ϵ�������� */
	private String contactName = "";
	/** �Ա� */
	private String contactSex = "";
	/** �绰�� */
	private String phone = "";
	/** �����ʼ��� */
	private String email = "";
	/** ��ַ�� */
	private String address = "";
	/** ���š� */
	private String dept = "";
	/** ְλ�� */
	private String pos = "";
	/** �ֻ� */
	private String mobilePhone = "";

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getContactCode() {
		return contactCode;
	}

	public void setContactCode(String contactCode) {
		this.contactCode = contactCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactSex() {
		return contactSex;
	}

	public void setContactSex(String contactSex) {
		this.contactSex = contactSex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
}
