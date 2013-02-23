package com.hros.cloth.service;

import java.util.List;

import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.domain.OrderHistory;

public interface ClothService {

	float getTotalConsumption(Integer orderHistoryID,float total);
	
	/**
	 * �˻�
	 * @param cloth
	 * @param count �˻�����
	 */
	void returnCloth(Cloth cloth,int count,String reason);
	
	/**
	 * 
	 * @param selectedOrder ѡ��Ķ���
	 * @param selectedCloth ѡ������·�
	 * @param consume  ���
	 * @return �����ɵĶ���
	 */
	OrderHistory cancelOrder(OrderHistory selectedOrder,Cloth selectedCloth,float consume);
	
	/**
	 * �����·�
	 * @param cloth
	 * @param selectedCustomer
	 */
	void orderCloth(Cloth cloth,Customer2 selectedCustomer,Float realPrice);
	
	/**
	 * ���϶���
	 * @param selectedOrder
	 */
	void invalidOrder(OrderHistory selectedOrder);
}
