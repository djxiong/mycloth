package com.hros.cloth.dao;

import java.util.List;
import java.util.Map;

import com.hros.cloth.domain.OrderHistory;



public interface OrderHistoryDao {

	OrderHistory getOrderHistoryByID(Integer id);
	
	void updateOrderHistory(OrderHistory orderHistory);
	
	void insertOrderHistory(OrderHistory orderHistory);
	
	void deleteOrderHistory(Integer id);
	
	List<OrderHistory> findOrderHistoryBetweenDate(Map map);
	
	List<OrderHistory> findOrderHistoryByClothID(Integer clothID);
	
	List<OrderHistory> findOrderHistoryByCustomerID(Integer clothID);
}
