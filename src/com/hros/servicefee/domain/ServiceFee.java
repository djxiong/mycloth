package com.hros.servicefee.domain;

public class ServiceFee {
	/** 服务费ID。 */
	private int serviceFeeID = 0;
	//父ID
	private int serviceFeeFid = 0;
	/** 服务费编码。 */
	private String serviceFeeCode = "";
	/** 服务费名称。 */
	private String serviceFeeName = "";
	/** java方法名。 */
	private String serviceFeeMethod = "";
	/** 天结算方式。 */
	private String dayFeeType = "";
	/** 天计算比例。 */
	private String dayFee = "";
	/** 月结算方式。 */
	private String monthFeeType = "";
	/** 月费用结算。
	 * 格式如下：
	 * 		非阶梯状：60 
	 * 		 阶梯状收费如下，1,2,3;30,50,60;60
	 * */
	private String monthFee = "";
	/** 延迟时间。 */
	private int delayDay = 0;
	/** 是否计算出勤天数比例*/
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
