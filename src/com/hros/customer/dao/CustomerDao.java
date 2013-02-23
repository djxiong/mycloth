package com.hros.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.customer.domain.Customer;

@Repository
public interface CustomerDao {
	public List<Customer> selectAllCustomer();
	
	public List<Customer> selectCustomer(String s);
	
	public void insertCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> selectFilterCustomer(Map map);
	
	/**
	 * 根据ID获取客户
	 * @param customerID
	 * @return
	 */
	public Customer getCustomerByID(Integer customerID);
}
