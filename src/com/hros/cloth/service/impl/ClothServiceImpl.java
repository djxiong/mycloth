package com.hros.cloth.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hros.cloth.dao.ClothDao;
import com.hros.cloth.dao.Customer2Dao;
import com.hros.cloth.dao.OrderHistoryDao;
import com.hros.cloth.dao.ReturnRecordDao;
import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.domain.OrderHistory;
import com.hros.cloth.domain.ReturnRecord;
import com.hros.cloth.service.ClothService;


@Repository
public class ClothServiceImpl implements ClothService {
	
	@Autowired
	private ClothDao clothDao;
	@Autowired
	private Customer2Dao customerDao;
	@Autowired
	private OrderHistoryDao orderHistoryDao;
	
	@Autowired
	private ReturnRecordDao returnRecordDao;
	
	
	@Override
	public float getTotalConsumption(Integer orderHistoryID,float total) {
		// TODO Auto-generated method stub
		
		OrderHistory orderHistory = orderHistoryDao.getOrderHistoryByID(orderHistoryID);
		total += orderHistory.getConsumption();
		
		if(orderHistory.getExchangedOrderID() != null && orderHistory.getExchangedOrderID() != 0){
			return getTotalConsumption(orderHistory.getExchangedOrderID(),total);
		}
		return total ;
	}


	@Override
	public void returnCloth(Cloth cloth, int count,String reason) {
		ReturnRecord record = new ReturnRecord();
		record.setClothID(cloth.getClothID());
		record.setCount(count);
		record.setReturnDate(new Date());
		record.setReason(reason);
		returnRecordDao.insertReturnRecord(record);
		
		cloth.setCount(cloth.getCount() - count);
		clothDao.updateCloth(cloth);
		
	}


	@Override
	public OrderHistory cancelOrder(OrderHistory selectedOrder,Cloth selectedCloth,float consume) {
		
		OrderHistory exchangedOrder  =  new OrderHistory();
		exchangedOrder.setClothID(selectedCloth.getClothID());
		exchangedOrder.setConsumeDate(new Date());
		exchangedOrder.setConsumption(consume);
		exchangedOrder.setProfit(consume);
		exchangedOrder.setCustomerID(selectedOrder.getCustomerID());
		exchangedOrder.setExchangedOrderID(selectedOrder.getOrderHistoryID());
		exchangedOrder.setOrderNumber(String.valueOf(System.currentTimeMillis()));
		exchangedOrder.setState(OrderHistory.STATE_SUCCESS);
		orderHistoryDao.insertOrderHistory(exchangedOrder);
		
		selectedOrder.setState(OrderHistory.STATE_EXCHANGE);
		orderHistoryDao.updateOrderHistory(selectedOrder);
		
		//新换的衣服数量减少1
		selectedCloth.setCount(selectedCloth.getCount() - 1);
		clothDao.updateCloth(selectedCloth);
		
		//原单里的衣服数量增加1
		Cloth oldCloth = clothDao.getClothByID(selectedOrder.getClothID());
		oldCloth.setCount(oldCloth.getCount() + 1);
		clothDao.updateCloth(oldCloth);
		
		return exchangedOrder;
	}


	@Override
	public void orderCloth(Cloth selectedCloth,Customer2 selectedCustomer,Float realPrice) {
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setClothID(selectedCloth.getClothID());
		orderHistory.setConsumeDate(new Date());
		//获取折扣后的价格
		orderHistory.setConsumption(realPrice);
		orderHistory.setProfit(realPrice - selectedCloth.getOriginalPrice());
		orderHistory.setState(OrderHistory.STATE_SUCCESS);
		orderHistory.setOrderNumber(String.valueOf(System.currentTimeMillis()));
		if(selectedCustomer != null){
			orderHistory.setCustomerID(selectedCustomer.getCustomer2ID());
		}
		orderHistoryDao.insertOrderHistory(orderHistory);
		
		//更新数量
		selectedCloth.setCount(selectedCloth.getCount() - 1);
		clothDao.updateCloth(selectedCloth);
	}


	@Override
	public void invalidOrder(OrderHistory selectedOrder) {
		selectedOrder.setState(OrderHistory.STATE_INVALID);
		Cloth oldCloth = clothDao.getClothByID(selectedOrder.getClothID());
		oldCloth.setCount(oldCloth.getCount() + 1);
		clothDao.updateCloth(oldCloth);
		orderHistoryDao.updateOrderHistory(selectedOrder);
	}

	

}
