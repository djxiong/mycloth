package com.hros.cloth.domain;

import java.util.Date;

import com.hros.insurance.domain.InsuranceDetailInfo;

public class Cloth {
	private Integer clothID;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 尺寸
	 */
	private String size;//S,M,L,XL,XXL
	/**
	 * 颜色
	 */
	private int color;
	/**
	 * 条形码
	 */
	private String barCode;
	/**
	 * 数量
	 */
	private Integer count;
	/**
	 * 促销类型,折扣或降价
	 */
	private String salesOffType = SALES_OFF_TYPE_ORIGINAL;
	public static final String SALES_OFF_TYPE_ORIGINAL="SALES_OFF_TYPE_ORIGINAL";
	public static final String SALES_OFF_TYPE_PERCENT="SALES_OFF_TYPE_PERCENT";
	public static final String SALES_OFF_TYPE_AMOUNT="SALES_OFF_TYPE_AMOUNT";
	/**
	 * 促销,折扣比或降价的金额
	 */
	private Float salesOff;
	
	/**
	 * 进货价
	 */
	private Float originalPrice;
	
	/**
	 * 挂牌价
	 */
	private Float price;
	
	/**
	 * 进货日期
	 */
	private Date stockDate;
	
	public Integer getClothID() {
		return clothID;
	}
	public void setClothID(Integer clothID) {
		this.clothID = clothID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSalesOffType() {
		return salesOffType;
	}
	public void setSalesOffType(String salesOffType) {
		this.salesOffType = salesOffType;
	}
	public Float getSalesOff() {
		return salesOff;
	}
	public void setSalesOff(Float salesOff) {
		this.salesOff = salesOff;
	}
	public Float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Float originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	
	public float getRealPrice(){
		if(salesOffType == null){
			return price;
		}
		if(salesOffType.equalsIgnoreCase(SALES_OFF_TYPE_ORIGINAL)){
			return price;
		}
		if(salesOffType.equalsIgnoreCase(SALES_OFF_TYPE_AMOUNT)){
			return price - salesOff;
		}
		if(salesOffType.equalsIgnoreCase(SALES_OFF_TYPE_PERCENT)){
			return price * salesOff;
		}
		return price;
	}
	
	
	@Override
	public boolean equals(Object another){
		if(! (another instanceof Cloth)){
			return false;
		}
		return clothID.equals(((Cloth)another).getClothID());
	}
	
	@Override
	public int hashCode(){
		return clothID.hashCode();
	}	
}
