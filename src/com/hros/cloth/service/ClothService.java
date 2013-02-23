package com.hros.cloth.service;

import java.util.List;

import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.domain.OrderHistory;

public interface ClothService {

	float getTotalConsumption(Integer orderHistoryID,float total);
	
	/**
	 * 退货
	 * @param cloth
	 * @param count 退货数量
	 */
	void returnCloth(Cloth cloth,int count,String reason);
	
	/**
	 * 
	 * @param selectedOrder 选择的订单
	 * @param selectedCloth 选择的新衣服
	 * @param consume  差价
	 * @return 新生成的订单
	 */
	OrderHistory cancelOrder(OrderHistory selectedOrder,Cloth selectedCloth,float consume);
	
	/**
	 * 购买衣服
	 * @param cloth
	 * @param selectedCustomer
	 */
	void orderCloth(Cloth cloth,Customer2 selectedCustomer,Float realPrice);
	
	/**
	 * 作废订单
	 * @param selectedOrder
	 */
	void invalidOrder(OrderHistory selectedOrder);
}
