package com.hros.servicefee.domain;

public class ServiceFee {
	/** �����ID�� */
	private int serviceFeeID = 0;
	//��ID
	private int serviceFeeFid = 0;
	/** ����ѱ��롣 */
	private String serviceFeeCode = "";
	/** ��������ơ� */
	private String serviceFeeName = "";
	/** java�������� */
	private String serviceFeeMethod = "";
	/** ����㷽ʽ�� */
	private String dayFeeType = "";
	/** ���������� */
	private String dayFee = "";
	/** �½��㷽ʽ�� */
	private String monthFeeType = "";
	/** �·��ý��㡣
	 * ��ʽ���£�
	 * 		�ǽ���״��60 
	 * 		 ����״�շ����£�1,2,3;30,50,60;60
	 * */
	private String monthFee = "";
	/** �ӳ�ʱ�䡣 */
	private int delayDay = 0;
	/** �Ƿ���������������*/
	private boolean isCalAttenDay = false;

	public int getServiceFeeID() {
		return serviceFeeID;
	}
	public void setServiceFeeID(int serviceFeeID) {
		this.serviceFeeID = serviceFeeID;
	}
	public String getServiceFeeCode() {
		return serviceFeeCode;
	}
	public void setServiceFeeCode(String serviceFeeCode) {
		this.serviceFeeCode = serviceFeeCode;
	}
	public String getServiceFeeName() {
		return serviceFeeName;
	}
	public void setServiceFeeName(String serviceFeeName) {
		this.serviceFeeName = serviceFeeName;
	}
	public String getServiceFeeMethod() {
		return serviceFeeMethod;
	}
	public void setServiceFeeMethod(String serviceFeeMethod) {
		this.serviceFeeMethod = serviceFeeMethod;
	}
	public String getDayFeeType() {
		return dayFeeType;
	}
	public void setDayFeeType(String dayFeeType) {
		this.dayFeeType = dayFeeType;
	}
	public String getDayFee() {
		return dayFee;
	}
	public void setDayFee(String dayFee) {
		this.dayFee = dayFee;
	}
	public String getMonthFeeType() {
		return monthFeeType;
	}
	public void setMonthFeeType(String monthFeeType) {
		this.monthFeeType = monthFeeType;
	}
	public String getMonthFee() {
		return monthFee;
	}
	public void setMonthFee(String monthFee) {
		this.monthFee = monthFee;
	}
	public int getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(int delayDay) {
		this.delayDay = delayDay;
	}
	public int getServiceFeeFid() {
		return serviceFeeFid;
	}
	public void setServiceFeeFid(int serviceFeeFid) {
		this.serviceFeeFid = serviceFeeFid;
	}
	public boolean isCalAttenDay() {
		return isCalAttenDay;
	}
	public void setCalAttenDay(boolean isCalAttenDay) {
		this.isCalAttenDay = isCalAttenDay;
	}
	   
}
